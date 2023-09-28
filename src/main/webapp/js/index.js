var Vue_one = new Vue({
    el: "#all",
    data() {
        return {
            dialog: false,
            radio: '登录',
            user: {},
            userLogin: {userName: ''},
            userRegister: {},
            userState: {},
            messageModel: {"login": "安全登录", "register": "立即注册"},
            articleModel: {"current": 1},
            discussModel: {"current": 1, "size": 5, "totalCount": 0},
            inputSearch: "",
            article: {articleDetails: ""},
            discuss: {discussDetails: ""},
            photos: {},
            isLoading: false,
            articlesLoading: false,
            zr: "A",
            co: "A",
            ts: "",
            li: 0,
            ty: 0,
            us: 0,
            gzpd:0,
        }
    },
    created: function () {
        this.articlesall();
        var _this = this;
        axios({
            method: "post",
            url: "http://localhost:8080/boke/Users/state",
        }).then(function (resp) {
            _this.userState = resp.data;
            if (_this.userState.code == 1) {
                _this.ty = 1;
                _this.articlesattention();
            } else {
                _this.ty = 0;
            }
        })
        // axios({
        //     method: "post",
        //     url: "http://localhost:8080/boke/Article/SelectAll",
        // }).then(function (resp) {
        //     _this.articleModel = resp.data;
        //
        // })

    },
    methods: {
        //验证登录状态
        State(){
            var _this = this;
            axios({
                method: "post",
                url: "http://localhost:8080/boke/Users/state",
            }).then(function (resp) {
                _this.userState = resp.data;
                if (_this.userState.code == 1) {
                    _this.ty = 1;
                } else {
                    _this.ty = 0;
                }
            })
        },
        //所有文章
        articlesall() {
            window.removeEventListener("scroll", this.handleScroll1, true);
            window.removeEventListener("scroll", this.handleScroll2, true);
            window.addEventListener('scroll', this.handleScroll, true);
            var _this = this;
            //表示正在加载数据
            this.isLoading = true;
            axios({
                method: "post",
                url: "http://localhost:8080/boke/Articles/selectArticleAll",
                params: {
                    currentpage: _this.articleModel.current,
                    userName:null
                }
            }).then(function (resp) {
                _this.articlesLoading = true;
                setTimeout(() => {
                    _this.articlesLoading = false;
                }, 400);
                _this.articleModel = resp.data;
                _this.isLoading = false;
            })

        },
        //关注用户的文章
        articlesattention() {
            window.removeEventListener("scroll", this.handleScroll, true);
            window.removeEventListener("scroll", this.handleScroll2, true);
            window.addEventListener('scroll', this.handleScroll1, true);
            var _this = this;
            //表示正在加载数据
            this.isLoading = true;
            axios({
                method: "post",
                url: "http://localhost:8080/boke/Articles/SelectAttentionArticle",
                params: {
                    currentpage: _this.articleModel.current
                }
            }).then(function (resp) {
                _this.articlesLoading = true;
                setTimeout(() => {
                    _this.articlesLoading = false;
                }, 400);
                _this.articleModel = resp.data;
                _this.isLoading = false;
            })

        },
        //滚动加载文章
        handleScroll() {
            if (this.isLoading) return;
            let scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
            let clientHeight = document.documentElement.clientHeight;
            let scrollHeight = document.documentElement.scrollHeight;
            if (scrollTop + clientHeight >= scrollHeight) { // 如果滚动到接近底部，自动加载下一页
                //事件处理
                this.articlesall();
                if (this.articleModel.code == 1) {
                    window.removeEventListener("scroll", this.handleScroll, true);
                }
            }
        },
        //滚动加载全部关注的文章
        handleScroll1() {
            if (this.isLoading) return;
            let scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
            let clientHeight = document.documentElement.clientHeight;
            let scrollHeight = document.documentElement.scrollHeight;
            if (scrollTop + clientHeight >= scrollHeight) { // 如果滚动到接近底部，自动加载下一页
                //事件处理
                this.articlesattention();
                if (this.articleModel.code == 1) {
                    window.removeEventListener("scroll", this.handleScroll1, true);
                }
            }
        },
        handleScroll2() {
            var _this = this;
            if (this.isLoading) return;
            let scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
            let clientHeight = document.documentElement.clientHeight;
            let scrollHeight = document.documentElement.scrollHeight;
            if (scrollTop + clientHeight >= scrollHeight) { // 如果滚动到接近底部，自动加载下一页
                //事件处理
                this.userarticle(_this.user.userName);
                if (this.articleModel.code == 1) {
                    window.removeEventListener("scroll", this.handleScroll2, true);
                }
            }
        },
        //根据登录状态判断文章选项
        loginpd(userName) {
            if (this.ty == 0) {
                return true;
            } else if (userName == this.userState.object.userName) {
                return false
            } else {
                return true;
            }
        },
        // 对是否关注了该用户的判断
        attentionpd(userName) {
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/boke/Users/followSelect",
                params: {
                    userName: userName
                }
            }).then(function (resp) {
                if (resp.data > 0) {
                    _this.gzpd=1;
                } else {
                    _this.gzpd=0;
                }
            })
        },
        //登录
        denglu() {
            var _this = this;
            axios({
                method: "post",
                url: "http://localhost:8080/boke/Users/login",
                data: _this.userLogin
            }).then(function (resp) {
                _this.userState = resp.data;
                _this.messageModel.login = _this.userState.msg;
                setTimeout(function () {
                    _this.messageModel.login = "安全登录";
                }, 1200);
                if (_this.userState.code == 1) {
                    setTimeout(function () {
                        _this.dialog = false;
                        _this.ty = 1;
                        // window.location.href = 'http://localhost:8080/boke/';
                    }, 1200);
                } else {
                    _this.ty = 0;
                    _this.userLogin.password = "";
                }
            })

        },
        //注册
        zhuce() {
            var _this = this;
            axios({
                method: "post",
                url: "http://localhost:8080/boke/Users/registe",
                data: _this.userRegister
            }).then(function (resp) {
                _this.messageModel.register = resp.data.msg;
                setTimeout(function () {
                    _this.messageModel.register = "立即注册";
                }, 2000);
                if (resp.data.code == 1) {
                    _this.$message({
                        type: 'success',
                        message: '注册成功!',
                        duration: 1000
                    });
                    _this.radio = '登录';
                    _this.zr = "A";
                    _this.userLogin.userName = _this.userRegister.userName;
                    for (let key of Object.keys(_this.userRegister)) {
                        Vue.delete(_this.userRegister, key);
                    }

                } else {
                    _this.userRegister.password = "";
                    _this.userRegister.passwordAgain = "";
                }
            })
        },
        //注销
        zhuxiao() {
            for (let key of Object.keys(this.userLogin)) {
                Vue.delete(this.userLogin, key);
            }
            for (let key of Object.keys(this.userRegister)) {
                Vue.delete(this.userRegister, key);
            }
            for (let key of Object.keys(this.userState)) {
                Vue.delete(this.userState, key);
            }
            for (let key of Object.keys(this.ty)) {
                Vue.delete(this.ty, key);
            }
            var _this = this;
            axios({
                method: "post",
                url: "http://localhost:8080/boke/Users/logout",
            }).then(function (resp) {
                if (resp.data == 1) {
                    _this.ty = 0;
                    _this.articlesall();
                }
            })
        },
        //文章添加
        articleadd() {
            var _this = this;
            if (this.article.articleDetails != "" && this.article.articleDetails != null) {
                axios({
                    method: "post",
                    url: "http://localhost:8080/boke/Articles/articleAdd",
                    params: {
                        articleDetails: _this.article.articleDetails
                    }
                }).then(function (resp) {
                    if (resp.data > 0) {
                        _this.$message({
                            message: '发布成功!',
                            type: 'success',
                            duration: 1000
                        });
                        _this.article.articleDetails = "";
                        _this.articlesall();
                    } else {
                        _this.$message({
                            message: '发布失败!',
                            type: 'error',
                            duration: 1000
                        });
                    }
                })
            } else {
                this.$message({
                    message: '发布内容不能为空',
                    type: 'error',
                    duration: 1000
                });
            }
        },
        //文章删除
        articledelete(id) {
            var _this = this;
            this.$confirm('确定删除微博么?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning',
                center: true
            }).then(() => {
                axios({
                    method: "post",
                    url: "http://localhost:8080/boke/Articles/articleDelete",
                    params: {id}
                }).then(function (resp) {
                    if (resp.data > 0) {
                        _this.$message({
                            type: 'success',
                            message: '删除成功!',
                            duration: 1000
                        });
                    } else {
                        _this.$message({
                            type: 'error',
                            message: '删除失败!',
                            duration: 1000
                        });
                    }
                    // axios({
                    //     method: "post",
                    //     url: "http://localhost:8080/boke/Article/SelectAll",
                    // }).then(function (resp) {
                    //     _this.articleModel = resp.data;
                    // })
                    _this.articlesall();
                })

            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除',
                    duration: 1000
                });
            });
        },
        //文章搜索
        sousuo() {
            window.removeEventListener("scroll", this.handleScroll, true);
            var _this = this;
            axios({
                method: "post",
                url: "http://localhost:8080/boke/Articles/articleSearch",
                params: {
                    inputSearch: _this.inputSearch
                }
            }).then(function (resp) {
                if (resp.data.code == 1) {
                    _this.articlesLoading = true;
                    setTimeout(() => {
                        _this.articlesLoading = false;
                    }, 400);
                    _this.articleModel = resp.data;
                    _this.isLoading = false;
                } else {
                    _this.$message({
                        message: '未查询到内容,',
                        duration: 1000
                    });
                }
            })
        },
        //文章修改信息的传递
        articletransmit(id, details) {
            document.documentElement.scrollTop = 0;
            this.article.articleId = id;
            this.article.articleDetails = details;
            this.co = 'B';
        },
        //文章修改
        articlemodify() {
            var _this = this;
            axios({
                method: "post",
                url: "http://localhost:8080/boke/Articles/articleModify",
                data: _this.article
            }).then(function (resp) {
                if (resp.data > 0) {
                    _this.$message({
                        type: 'success',
                        message: '修改成功!',
                        duration: 1000
                    });
                    _this.article.articleId = "";
                    _this.article.articleDetails = "";
                    _this.co = "A";
                    // axios({
                    //     method: "post",
                    //     url: "http://localhost:8080/boke/Article/SelectAll",
                    // }).then(function (resp) {
                    //     _this.articleModel = resp.data;
                    // })
                    _this.articlesall();
                } else {
                    _this.$message({
                        type: 'error',
                        message: '修改失败!',
                        duration: 1000
                    });
                }
            })
        },
        //其他用户主页详情
        userdetails(userName) {
            window.removeEventListener("scroll", this.handleScroll, true);
            window.removeEventListener("scroll", this.handleScroll1, true);
            window.addEventListener('scroll', this.handleScroll2, true);
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/boke/Users/userDetails",
                params: {
                    userName: userName
                }
            }).then(function (resp) {
                _this.user = resp.data;
                _this.us = 1;
                _this.ts = '';
                _this.userarticle(userName);
            })

        },
        //单个用户所有文章
        userarticle(userName){
            var _this = this;
            axios({
                method: "post",
                url: "http://localhost:8080/boke/Articles/selectArticleAll",
                params: {
                    currentpage: _this.articleModel.current,
                    userName: userName
                }
            }).then(function (resp) {
                _this.articlesLoading = true;
                setTimeout(() => {
                    _this.articlesLoading = false;
                }, 400);
                _this.articleModel = resp.data;
                _this.isLoading = false;
            })


        },
        //评论添加
        discussadd(articleId) {
            var _this = this;
            this.discuss.articleId = articleId;
            this.discuss.discussLike = 0;
            if (this.discuss.discussDetails != "" && this.discuss.discussDetails != null) {
                axios({
                    method: "post",
                    url: "http://localhost:8080/boke/Discuss/discussAdd",
                    data: _this.discuss
                }).then(function (resp) {
                    if (resp.data > 0) {
                        _this.$message({
                            message: '发布成功!',
                            type: 'success',
                            duration: 1000
                        });
                        _this.discuss.discussDetails = "";
                        _this.selectdiscuss(articleId);
                    } else {
                        _this.$message({
                            message: '发布失败!',
                            type: 'error',
                            duration: 1000
                        });
                    }
                })
            } else {
                this.$message({
                    message: '发布内容不能为空',
                    type: 'error',
                    duration: 1000
                });
            }


        },
        //评论选项按钮的判断
        showdiscuss(articleId, key) {
            this.discussModel.current = 1;
            if (this.ts === key) {
                this.ts = '';
                return
            } else {
                this.ts = key;
                this.selectdiscuss(articleId);
            }
        },
        //文章评论（分页查询）
        selectdiscuss(articleId) {
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/boke/Discuss/selectDiscuss",
                params: {
                    articleId: articleId,
                    current: _this.discussModel.current,
                    size: _this.discussModel.size
                }
            }).then(function (resp) {
                _this.discussModel = resp.data;
            })
        },
        //照片遍历
        photoselect(userName) {
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/boke/Photo/PhotoAll",
                params: {
                    userName: userName,
                }
            }).then(function (resp) {
                _this.photos = resp.data;
            })
        },
        //关注该用户
        followusers(userName) {
            var _this=this;
            if (this.ty==0){
                // this.dialog=true;
                // this.$message({
                //     message: '请先登录',
                //     type: 'warning',
                //     duration: 1000
                // });
            }
            axios({
                method: "get",
                url: "http://localhost:8080/boke/Users/followUsers",
                params: {
                    userName: userName,
                }
            }).then(function (resp) {
                _this.gzpd=1;
                _this.State();
                _this.userdetails(userName);
            })

        },
        //取消关注该用户
        unsubscribe(userName){
            var _this=this;
            axios({
                method: "get",
                url: "http://localhost:8080/boke/Users/unFollow",
                params: {
                    userName: userName,
                }
            }).then(function (resp) {
                _this.gzpd=0;
                _this.State();
                _this.userdetails(userName);
            })

        },
        // 用户点赞
        userlike(articleId) {
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/boke/User/UserLike",
                params: {
                    articleId: articleId,
                }
            }).then(function (resp) {

            })

        },
        userunlike(articleId) {
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/boke/User/UserUnLike",
                params: {
                    articleId: articleId,
                }
            }).then(function (resp) {

            })

        },
        handleSizeChange(articleId, val) {
            this.discussModel.size = val;
            this.selectdiscuss(articleId);
        },
        handleCurrentChange(articleId, val) {
            this.discussModel.current = val;
            this.selectdiscuss(articleId);
        }
    },
    mounted() {
        window.addEventListener('scroll', this.handleScroll, true);
    },
    beforeDestroy() {
        //document.querySelector("body").removeAttribute("style");
        window.removeEventListener("scroll", this.handleScroll, true);
    },

});
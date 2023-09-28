var Vue_one = new Vue({
    el: "#all",
    data() {
        return {
            dialog: false,
            userState: {},
            userModify: {"oldPassword": '', "password": '', "passwordAgain": ''},
            messageModel: {"usermodify": "修改"},
            articleModel: {"current": 1},
            discussModel: {"current": 1, "size": 5, "totalCount": 0},
            focusModel: {"current": 1, "size": 15, "totalCount": 0},
            article: {articleDetails: ""},
            discuss: {discussDetails: ""},
            isLoading: false,
            articlesLoading: false,
            co: "A",
            ts: "",
            li: 0,
            ty:0,
            personaloptions: "myhome",
            dialogImageUrl: '',
            dialogVisible: false,
            disabled: false,
            photos: {},
        }
    },
    created: function () {
        var _this = this;
        axios({
            method: "post",
            url: "http://localhost:8080/boke/Users/state",
        }).then(function (resp) {
            _this.userState = resp.data;
            if (_this.userState.code == 1) {
                _this.ty = 1;
                _this.userarticle();
            } else {
                _this.ty = 0;
            }
        })

    },
    methods: {
        //验证登录状态
        State() {
            var _this = this;
            axios({
                method: "post",
                url: "http://localhost:8080/boke/Users/state",
            }).then(function (resp) {
                _this.userState = resp.data;
            })
        },
        //显示登录用户的所有文章
        userarticle() {
            var _this = this;
            //表示正在加载数据
            this.isLoading = true;
            axios({
                method: "get",
                url: "http://localhost:8080/boke/Articles/selectArticleAll",
                params: {
                    currentpage: _this.articleModel.current,
                    userName: _this.userState.object.userName
                }
            }).then(function (resp) {
                _this.articlesLoading = true;
                setTimeout(() => {
                    _this.articlesLoading = false;
                }, 600);
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
                this.userarticle();
                if (this.articleModel.code == 1) {
                    window.removeEventListener("scroll", this.handleScroll, true);
                }
            }
        },
        //注销
        zhuxiao() {
            for (let key of Object.keys(this.userState)) {
                Vue.delete(this.userState, key);
            }
            var _this = this;
            axios({
                method: "post",
                url: "http://localhost:8080/boke/Users/logout",
            }).then(function (resp) {
                window.location.href = 'http://localhost:8080/boke/';
            })
        },
        //发布文章
        articleadd() {
            var _this = this;
            if (this.article.articleDetails != "" && this.article.articleDetails != null) {
                axios({
                    method: "post",
                    url: "http://localhost:8080/boke/Articles/articleAdd",
                    params: {
                        articledetails: _this.article.articleDetails
                    }
                }).then(function (resp) {
                    if (resp.data > 0) {
                        _this.$message({
                            message: '发布成功!',
                            type: 'success',
                            duration: 1000
                        });
                        _this.article.articleDetails = "";
                        // axios({
                        //     method: "post",
                        //     url: "http://localhost:8080/boke/Article/SelectAll",
                        // }).then(function (resp) {
                        //     _this.articleModel = resp.data;
                        // })
                        _this.userarticle();
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
        //删除文章
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
                    _this.userarticle();

                })
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除',
                    duration: 1000
                });
            });
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
                    _this.userarticle();
                } else {
                    _this.$message({
                        type: 'error',
                        message: '修改失败!',
                        duration: 1000
                    });
                }
            })
        },
        //密码修改
        xiugai() {
            var _this = this;
            this.userModify.userName = this.userState.object.userName;
            axios({
                method: "post",
                url: "http://localhost:8080/boke/Users/modifyPassword",
                data: _this.userModify
            }).then(function (resp) {
                _this.userState = resp.data;
                _this.messageModel.usermodify = resp.data.msg;
                if (resp.data.code == 1) {
                    _this.$message({
                        type: 'success',
                        message: '修改成功!',
                        duration: 1000
                    });
                    for (let key of Object.keys(_this.userModify)) {
                        Vue.delete(_this.userModify, key);
                    }
                } else {
                    _this.$message({
                        type: 'error',
                        message: '修改失败!',
                        duration: 1000
                    });
                }
            })
        },
        //评论添加
        discussadd(articleId) {
            var _this = this;
            this.discuss.articleId = articleId;
            this.discuss.discussLike = 0;
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
                    // axios({
                    //     method: "post",
                    //     url: "http://localhost:8080/boke/Article/SelectAll",
                    // }).then(function (resp) {
                    //     _this.articleModel = resp.data;
                    // })
                    _this.selectdiscuss(articleId);
                } else {
                    _this.$message({
                        message: '发布失败!',
                        type: 'error',
                        duration: 1000
                    });
                }
            })

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
        //取消关注该用户
        unsubscribe(userName) {
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/boke/Users/unFollow",
                params: {
                    userName: userName,
                }
            }).then(function (resp) {
                _this.State();
                _this.followlist();
            })

        },
        //查询关注用户列表
        followlist() {
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/boke/Users/followList",
                params: {
                    current: _this.focusModel.current,
                    size: _this.focusModel.size
                }
            }).then(function (resp) {
                _this.focusModel = resp.data;
            })

        },
        handleSizeChange(articleId, val) {
            this.discussModel.size = val;
            this.selectdiscuss(articleId);
        },
        handleCurrentChange(articleId, val) {
            this.discussModel.current = val;
            this.selectdiscuss(articleId);
        },
        handleRemove(file) {
            console.log(file);
        },
        handlePictureCardPreview(file) {
            this.dialogImageUrl = file.url;
            this.dialogVisible = true;
        },
        handleDownload(file) {
            console.log(file);
        },
        successImg(res, file) {
            console.log(res.data.path);
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
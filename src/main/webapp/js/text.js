var Vue_one = new Vue({
    el: "#all",
    data() {
        return {
            dialogImageUrl: '',
            dialogVisible: false,
            disabled: false,
            photos:{},
        }
    },
    created: function (){
        _this =this;
        axios({
            method: "post",
            url: "http://localhost:8080/boke/Photo/PhotoAll",
        }).then(function (resp) {
            _this.photos = resp.data;
        })
    },
    methods: {

    },

});
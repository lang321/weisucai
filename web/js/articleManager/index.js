(function () {
    $(function(){
        var current=1;
        //局部注册
        Vue.component("page",{
            template:'<ul class="pagination" >\n' +
            '    <li v-show="current != 1" @click="current>1 && goto(current-1)" ><a>上一页</a></li>\n' +
            '    <li :id="\'li\'+index" v-for="index in pages" @click="goto(index)" :class="{\'active\':current == index}" :key="index">\n' +
            '        <a >{{index}}</a>\n' +
            '    </li>\n' +
            '    <li v-show="allpage != current && allpage != 0 " @click="current++ && goto(current++)"><a >下一页</a></li>\n' +
            '    <li ><a >共{{allpage}}页</a></li>'+
            '</ul>',
            props:{
                // current:{
                //     type:Number,
                //     default:1
                // },
                allpage:{ //总页数,和父组件同步
                    type:Number,
                    default:1
                },
            },
            data:function(){
                return{
                    current:1,
                    showItem:5
                }
            },
            computed:{
                pages:function(){
                    var pag = [];
                    if( this.current < this.showItem ){ //如果当前的激活的项 小于要显示的条数
                        //总页数和要显示的条数那个大就显示多少条
                        var i = Math.min(this.showItem,this.allpage);
                        while(i){
                            pag.unshift(i--);
                        }
                    }else{ //当前页数大于显示页数了
                        var middle = this.current - Math.floor(this.showItem / 2 ),//从哪里开始
                            i = this.showItem;
                        if( middle >  (this.allpage - this.showItem)  ){
                            middle = (this.allpage - this.showItem) + 1
                        }
                        while(i--){
                            pag.push( middle++ );
                        }
                    }
                    return pag
                }
            },
            methods:{
                goto:function(index){
                    if(index == this.current) return;
                    this.current = index;
                    //这里可以发送ajax请求
                    Articles.search(index);
                }
            }
        })

        var Articles = new Vue({
            el:"#articles",
            data:{
                //一页容量
                pageSize:5,
                //当前页
                pageIndex:1,
                allpage:10, //总页数
                //领域
                area:0,
                //time
                time:0,
                original:1,
                keyWord:"",
                articles:[]
            },
            methods:{
                //初始化,第一页，筛选【all，all，all】
                init:function(){
                    this.pageIndex=1;
                    this.setAllPage()
                    this.search(1)
                },
                // 根据标题关键字筛选 动态搜索 返回bool类型
                search:function(pageIndex){
                    this.articles=[]
                    var _this=this
                    var params={}
                    params.pageIndex=pageIndex
                    params.pageSize=this.pageSize
                    params.area=this.area
                    params.time=this.time
                    params.keyWord=this.keyWord
                    params.original=this.original
                    $.ajax({
                        url:"/article/getArticleRange",
                        type:"post",
                        data:params,
                        success:function (rs) {
                            console.log(rs)
                            for(i in rs){
                                _this.articles.push(rs[i])
                            }
                        },
                        error:function () {
                            alert("文章加载失败")
                        }
                    })

                },
                //计算总页数
                setAllPage:function () {
                    var _this = this
                    var params={}
                    params.pageSize=this.pageSize
                    params.area=this.area
                    params.time=this.time
                    params.keyWord=this.keywords
                    params.original=this.original
                    $.ajax({
                        url:'/article/getAllPage',
                        type:'post',
                        data:params,
                        success:function(rs){
                            _this.allpage=rs
                        },error:function () {

                        }
                    })
                },
                editArticle:function (id) {
                    // alert(id)
                },
            }
        })

        //分页


        //领域
        var AreaVue = new Vue({
            el:"#area",
            data:{
                // areas:[{id:1,name:"法律"},{id:2,name:"十九大"},
                //     {id:3,name:"技术"},{id:4,name:"移民"}],
                areas:[],
                d:[1,2,3,4,5]
            },
            methods:{
                init:function(){
                    var _this=this
                    $.ajax({
                        url:"/area/getAreas",
                        type:"post",
                        success:function(rs){
                            for(i in rs){
                                //这里的this作用域
                                _this.areas.push(rs[i])
                            }
                        },error:function () {
                            alert("获取领域信息失败")
                        }
                    })
                },
                //事件
                selectArea:function (id,event) {
                    //颜色
                    $(event.target).addClass("active")
                    $(event.target).siblings().removeClass("active")
                    Articles.area=id
                    //更换领域，第一页
                    Articles.search(1)
                    $('#li1').click()
                }
            }
        })
        AreaVue.init()
        Articles.init()
    })
})()
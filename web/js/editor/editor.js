(function () {
    $(function () {
        //领域
        var AreaVue = new Vue({
            el: "#area",
            data: {
                // areas:[{id:1,name:"法律"},{id:2,name:"十九大"},
                //     {id:3,name:"技术"},{id:4,name:"移民"}],
                areas: [],
                selectedId: 0,
                d: [1, 2, 3, 4, 5]
            },
            methods: {
                init: function () {
                    var _this = this
                    $.ajax({
                        url: "/area/getAreas",
                        type: "post",
                        success: function (rs) {
                            for (i in rs) {
                                //这里的this作用域
                                _this.areas.push(rs[i])
                            }
                        }, error: function () {
                            alert("获取领域信息失败")
                        }
                    })
                },
                //事件
                selectArea: function (id, event) {
                    //颜色
                    $(event.target).addClass("active")
                    $(event.target).siblings().removeClass("active")
                    // Articles.area=id
                    AreaVue.selectedId = id
                    //更换领域，第一页
                    // Articles.search(1)
                }
            }
        })
        AreaVue.init()

        var original = 1
        $("#original button").click(function () {
            //颜色
            $(this).addClass("active")
            $(this).siblings().removeClass("active")
            //查询
            original = $(this).attr('name')
            alert(original)
        })

        //手动提交表单 area,original

        var form = $('#releaseForm')
        form.submit(function () {
            if (AreaVue.selectedId == 0) {
                alert('请选择文章领域！')
                return false;
            }
            var areaInput=$('<input type="text" name="area" />')
            areaInput.attr('value',AreaVue.selectedId)
            form.append(areaInput)
            var originalInput = $('<input type="text" name="original" />')
            originalInput.attr('value',original)
            form.append(originalInput)
            var titleInput = $('<input type="text" name="title" />')
            var title = $("#title")[0].value
            alert(title)
            titleInput.attr('value',title)
            form.append(titleInput)
            // alert(form[0].content.value)
        })
    })
})()
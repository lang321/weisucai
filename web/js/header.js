(function () {
  $(function () {
      //判断登录？
      var loginLi = $('.loginLi')
      var noLogin = $('.noLogin')
      $.ajax({
          url:"/user/isLogin",
          type:"post",
          success:function (rs) {
              if(rs==1){
                  loginLi.css("display","none")
                  // loginLi.addClass('remove')
                  noLogin.css("display","block")
              }
              else{
                // alert('还没有登录')
                  loginLi.css("display","block")
                noLogin.css("display","none")
              }
          }
      })

      //下拉菜单
      var img = $('#img')
      var menu = $('.topbar-info-dropdown-memu')
      var i=0
      var timer
      menu.hide()
      img.mouseenter(function () {
          clearTimeout(timer)
          menu.show()
      })
      img.mouseleave(function () {
          timer = window.setTimeout(function () {
              menu.hide()
          },500)
      })
      menu.mouseenter(function () {
          clearTimeout(timer)
          // menu.css('visibility','vidible')
      })
      menu.mouseleave(function () {
          menu.hide()
      })
  })  
})()
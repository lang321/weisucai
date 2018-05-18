(function () {
    $('#headerWrap').load('/header')
    $('#footerWrap').load('/footer')

    //鼠标移动到step上
    $('#stepsWrap .step').hover(function () {
        $(this).find('p').css('color', '#d36e3f')
        $(this).find('span').css('background-color', '#d36e3f')
        $(this).siblings()
        $(this).siblings().find('p').css('color', 'black')
        $(this).siblings().find('span').css('background-color', '#666')
        var num = $(this).attr('name')

        //轮播
        $('#myCarousel').carousel(num-1)
    })

})()
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>编辑文章</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="微素材">
	<meta name="description" content="寻找微素材" />

	<link rel="icon" href="/images/icons/logo.png" type="image/x-icon"/>

	<link rel="stylesheet" href="/resource/kindeditor-master/themes/default/default.css" />
	<link rel="stylesheet" href="/resource/kindeditor-master/plugins/code/prettify.css" />
	<link href="/css/myCommon.css" rel="stylesheet" type="text/css" />
	<link href="/css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css" />


	<script src="/js/jquery-2.1.4.min.js"></script>
	<script charset="utf-8" src="/resource/kindeditor-master/kindeditor-all.js"></script>
	<script charset="utf-8" src="/resource/kindeditor-master/lang/zh-CN.js"></script>
	<script charset="utf-8" src="/resource/kindeditor-master/plugins/code/prettify.js"></script>

	<script src="/js/editor/editor.js"></script>

	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea', {
			    width:'100%',
				height:'600px',
				items:[
                    'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
                    'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
                    'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
                    'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
                    'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
                    'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'multiimage',
                    'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
                    'anchor', 'link', 'unlink', '|', 'about'
				],
				cssPath : '/resource/kindeditor-master/plugins/code/prettify.css',
				uploadJson : '/edit/fileUpload',
				fileManagerJson : '/edit/fileManager',
				allowFileManager : true,
				afterCreate : function() {
                    var self = this;
                    K.ctrl(document, 13, function() {
                        self.sync();
                        document.forms['example'].submit();
                    });
                    K.ctrl(self.edit.doc, 13, function() {
                        self.sync();
                        document.forms['example'].submit();
                    });
                    //粘贴图片
                    var editerDoc = this.edit.doc;//得到编辑器的文档对象
                    //监听粘贴事件, 包括右键粘贴和ctrl+v
                    $(editerDoc).bind('paste', null, function (e) {
                        /*获得操作系统剪切板里的项目，e即kindeditor,
                         *kindeditor创建了originalEvent(源事件)对象，
                         *并指向了浏览器的事件对象，而chrome浏览器
                         *需要通过clipboardData(剪贴板数据)对象的items
                         *获得复制的图片数据。
                         */
                        var ele = e.originalEvent.clipboardData.items;
                        for (var i = 0; i < ele.length; ++i) {
                            //判断文件类型
                            if ( ele[i].kind == 'file' && ele[i].type.indexOf('image/') !== -1 ) {
                                var file = ele[i].getAsFile();//得到二进制数据
                                //创建表单对象，建立name=value的表单数据。
                                var formData = new FormData();
                                formData.append("imgFile",file);//name,value

                                //用jquery Ajax 上传二进制数据
                                $.ajax({
                                    url : '/edit/fileUpload?dir=image',
                                    type : 'POST',
                                    data : formData,
                                    // 告诉jQuery不要去处理发送的数据
                                    processData : false,
                                    // 告诉jQuery不要去设置Content-Type请求头
                                    contentType : false,
                                    dataType:"json",
                                    beforeSend:function(){
                                        //console.log("正在进行，请稍候");
                                    },
                                    success : function(responseStr) {
                                        //上传完之后，生成图片标签回显图片，假定服务器返回url。
                                        var src = responseStr.url;
                                        var imgTag = "<img src='"+src+"' border='0'/>";

                                        //console.info(imgTag);
                                        //kindeditor提供了一个在焦点位置插入HTML的函数，调用此函数即可。
                                        editor1.insertHtml(imgTag);


                                    },
                                    error : function(responseStr) {
                                        console.log("error");
                                    }
                                });
                            }
                        }
                    });
                }
			});
			prettyPrint();
            <%--editor1.html('${article!=null?article.content:""}');--%>
		});
		$.ajax({
			url:'',
			type:'post',
			success:function (rs) {
				
            }
		})
	</script>
</head>
<body>
<div class="container">
	<div id="headerWrap"></div>
	<script>
        //加载header
        $('#headerWrap').load('/header');
	</script>
	<div class="row clearfix">
		<div class="col-md-12" style="margin-bottom: 50px">
			<!--领域-->
			<div id="area" style="padding: 10px 0;">
				<label class="control-label" style="padding: 10px 10px">领域</label>
				<div class="btn-group" role="group" aria-label="...">
					<button @click="selectArea(item.id,$event)" v-for="item in areas" type="button" class="btn btn-default">
						{{item.name}}
					</button>
				</div>
			</div>
			<!--原创[1]、网络[0]-->
			<div id="original" style="padding: 10px 0;">
				<label class="control-label" style="padding: 10px 10px">来自</label>
				<div class="btn-group" role="group" aria-label="...">
					<button type="button" class="btn btn-default active" name="1" style="margin-right: 5px;">原创</button>
					<button type="button" class="btn btn-default" name="0">网络</button>
				</div>
			</div>
			<div >
				<div class="form-group" style="display: flex; flex-direction: row">
					<label for="title" class="control-label" style="padding: 10px 10px">  &nbsp;标题</label>
					<div class="" style="padding: 10px 10px; ">
						<input value='${article!=null?article.title:""}' type="text" width="90%" class="form-control" name="title" id="title" placeholder="请输入标题">
					</div>
				</div>
			</div>
			<div id="articleEditor">
				<form name="example" id="releaseForm" method="post" action="/edit/releaseArticle">
					<textarea name="content" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea>
					<br />
					<input type="submit" value="提交内容" /> (提交快捷键: Ctrl + Enter)
					<%--<button type="button" id="releaseBtn" class="btn btn-default">发布</button> (提交快捷键: Ctrl + Enter)--%>
				</form>
			</div>



		</div>
	</div>
	<div id="footerWrap"></div>
	<script>
        //加载footer
        $('#footerWrap').load('/footer');
	</script>
</div>

	<script src="/js/bootstrap/bootstrap.js"></script>
<script src="/js/vue/vue.js"></script>
</body>
</html>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@taglib uri="/page" prefix="pg"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/editor/kindeditor/themes/default/default.css" />
<link href="${pageContext.request.contextPath }/css/myForm.css" rel="stylesheet">
<script charset="utf-8" src="${pageContext.request.contextPath }/editor/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="${pageContext.request.contextPath }/editor/kindeditor/lang/zh_CN.js"></script>
<script>
	KindEditor.ready(function(K) {
		var editor = K.editor({
			allowFileManager : true
		});
		K('#image').click(function() {
			editor.loadPlugin('image', function() {
				editor.plugin.imageDialog({
					imageUrl : K('#url').val(),
					clickFn : function(url, title, width, height, border, align) {
						K('#url').val(url);
						editor.hideDialog();
						K('#new_image').attr("src",url);
					}
				});
			});
		});

	});
</script>
</head>
<body>
	<%@include file="/manager/common/top_nav.jsp" %>
	<div class="main">
		<%@include file="/manager/common/left_nav.jsp" %>
		<div class="main-roght col-md-10">
			<form method="post" class="form-horizontal myForm" action="${pageContext.request.contextPath }/manager/updateSlideAdvs.action">
				
				<input type="hidden" name="slideAdvsId" value="${slideAdvs.slideAdvsId }">
				<input type="hidden" name="userWeiXinId" value="${slideAdvs.userWeiXinId }">
				<div class="form-group">
					<label class="col-md-2 control-label">幻灯片描述</label>
					<div class="col-md-4">
						<input class="form-control" type="text" name="advsName" value="${slideAdvs.advsName }">
					</div>
				</div>					
				<div class="form-group">					
					<label class="col-md-2 control-label">图片地址</label>
					<div class="col-md-4">
						<input class="form-control" type="text" id="url" name="advsImage" value="${slideAdvs.advsImage }"/>
					</div>
					<div class="col-md-4">
						<input class="btn btn-primary" type="button" id="image" value="选择图片" />（网络图片 + 本地上传）
					</div>
				</div>	
				<div class="form-group">		
					<div class="col-md-offset-2 col-md-4" >
						<img id="new_image" src="${slideAdvs.advsImage }"  width="120" height="120">									
					</div>			
				</div>				
				<div class="form-group">
					<label class="col-md-2 control-label">链接地址</label>
					<div class="col-md-4">
						<input class="form-control" type="text" name="advsUrl" value="${slideAdvs.advsUrl }">
					</div>
				</div>								

				<div class="form-group">
					<div class="col-md-offset-2 col-md-4">
						<button type="submit" class="btn btn-success">确认修改</button>
					</div>
				</div>	
			</form>
		
		</div>
	</div>		
</body>
</html>
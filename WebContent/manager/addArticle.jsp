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
		K.create('#content1', {
			themeType : 'default'
		});
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
			<form method="post" class="form-horizontal myForm" action="${pageContext.request.contextPath }/manager/addArticle.action">
				
				<input type="hidden" name="userWeiXinId" value="${userWeiXinId }">
				<div class="form-group">
					<label class="col-md-2 control-label">文章标题</label>
					<div class="col-md-4">
						<input class="form-control" type="text" name="title">
					</div>
				</div>	
				<div class="form-group">
					<label class="col-md-2 control-label">所属类别</label>
					<div class="col-md-4">
						<select class="form-control" name="cateId">
							<c:forEach items="${list }" var="r">
								<option value="${r.cateId }">
									${r.cateName }
								</option>
							</c:forEach>
						</select>
					</div>
				</div>												
				<div class="form-group">					
					<label class="col-md-2 control-label">封面图片</label>
					<div class="col-md-4">
						<input class="form-control" type="text" id="url" name="articleImage"/>
					</div>
					<div class="col-md-4">
						<input class="btn btn-primary" type="button" id="image" value="选择图片" />（网络图片 + 本地上传）
					</div>
				</div>	
				<div class="form-group">		
					<div class="col-md-offset-2 col-md-4" >
						<img id="new_image" src=""  width="120" height="120">									
					</div>			
				</div>				
				<div class="form-group">
					<label class="col-md-2 control-label">外部连接地址</label>
					<div class="col-md-4">
						<input class="form-control" type="text" name="articleUrl">
					</div>
				</div>					
				<div class="form-group">
					<label class="col-md-2 control-label">图文详细内容</label>
					<div class="col-md-4">
						<textarea id="content1" class="form-control" name="articleContext" style="height: 350px"></textarea>
					</div>
				</div>					

				<div class="form-group">
					<div class="col-md-offset-2 col-md-4">
						<button type="submit" class="btn btn-success">确认添加</button>
					</div>
				</div>	
			</form>
		
		</div>
	</div>		
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/page" prefix="pg"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/my.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
</head>
<body>
<div class="back">
	<%@include file="/manager/common/top_nav.jsp" %>
	
	
	<div class="main">
		<%@include file="/manager/common/left_nav.jsp" %>
		
		<div class="main-roght col-md-10">			
			<table class="table table-hover">
				<caption>
					<a href="${pageContext.request.contextPath }/manager/addPreArticle.action">
						<button type="button" class="btn btn-success">
							添加文章
						</button>
					</a>
				</caption>
				<thead>
					<tr>
						<th>文章标题</th>
						<th>分类</th>
						<th>封面图片</th>
						<th>外部连接地址</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>		
					<c:forEach items="${paging.data }" var="a">
						<tr>			
							<td>${a.title }</td>
							<td>${a.category.cateName }</td>
							<td>
								 <img  src="${a.articleImage }"  width="120" height="120" />
							</td>				
							<td>${a.articleUrl }</td>
							<td>
								<a href="${pageContext.request.contextPath }/manager/updatePreArticle.action?id=${a.articleId}">编辑</a>
								<a href="${pageContext.request.contextPath }/manager/deleteArticle.action?id=${a.articleId}">删除</a>
								<span class="alert-danger">${msg }</span>
							</td>
						</tr>
					</c:forEach>				
				</tbody>				
			</table>
			<div>
        		<pg:navigation url="${pageContext.request.contextPath }/manager/showArticle.action" pageUtil="${paging}"/>			
			</div>
		</div>
		
	</div>
	
</div>
</body>
</html>
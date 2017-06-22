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
					<a href="${pageContext.request.contextPath }/manager/addSlideAdvs.jsp">
						<button type="button" class="btn btn-success">
							添加幻灯片
						</button>
					</a>
				</caption>
				<thead>
					<tr>
						<th>幻灯片描述</th>
						<th>图片</th>
						<th>链接地址</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>	
					<c:forEach items="${paging.data }" var="s">
						<tr>			
							<td>${s.advsName }</td>
							<td>
								 <img  src="${s.advsImage }"  width="120" height="120" />
							</td>				
							<td>${s.advsUrl }</td>
							<td>
								<a href="">查看</a>				
								<a href="${pageContext.request.contextPath }/manager/updatePreSlideAdvs.action?id=${s.slideAdvsId}">编辑</a>
								<a href="${pageContext.request.contextPath }/manager/deleteSlideAdvs.action?id=${s.slideAdvsId}">删除</a>
								<span class="alert-danger">${msg }</span>
							</td>
						</tr>
					</c:forEach>				
				</tbody>				
			</table>
			<div>
        		<pg:navigation url="${pageContext.request.contextPath }/manager/showSlideAdvs.action" pageUtil="${paging}"/>			
			</div>
		</div>
		
	</div>
	
</div>
</body>
</html>
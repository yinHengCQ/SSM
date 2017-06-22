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
					<form class="form-inline" action="${pageContext.request.contextPath }/manager/addReply.action">
						<input type="hidden" name="userWeiXinId" value="${userWeiXinId}">					
						<div class="form-group">
							<input class="form-control" type="text" name="replyKeyWords" placeholder="输入新增关键字">
						</div>
						<div class="form-group">
							<input class="btn btn-success" type="submit" value="添加关键字">
						</div>
					</form>
				</caption>
				<thead>
					<tr>
						<th>关键字</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>	
					<c:forEach items="${paging.data }" var="r">
						<tr>			
							<td>${r.replyKeyWords }</td>
							<td>
								<a href="${pageContext.request.contextPath }/manager/showReplyNews.action?id=${r.replyId}">查看或编辑</a>
								<a href="${pageContext.request.contextPath }/manager/deleteReply.action?id=${r.replyId}">删除</a>
								<span class="alert-danger">${msg }</span>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div>
        		<pg:navigation url="${pageContext.request.contextPath }/manager/showReply.action" pageUtil="${paging}"/>			
			</div>
			
		</div>
		
	</div>

</div>	
</body>
</html>
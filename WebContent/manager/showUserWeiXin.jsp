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
			<c:if test="${empty userWeiXinId }">
				<table class="table table-hover">
					<caption>
						<a href="${pageContext.request.contextPath }/manager/addUserWeiXin.jsp">
							<button type="button" class="btn btn-success">
								添加微信公众号
							</button>
						</a>
					</caption>
					<thead>
						<tr>
							<th>微信原始ID</th>
							<th>微信头像</th>
							<th>二维码</th>
							<th>微信公众号名称</th>
							<th>微信号</th>
							<th>微信类型</th>
							<th>token</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>		
						<c:forEach items="${paging.data }" var="u">
							<tr>
								<td>${u.wxId }</td>
								<td>
									 <img  src="${u.wxHead }"  width="120" height="120" />
								</td>
								<td>
									 <img  src="${u.qrCode }"  width="120" height="120" />
								</td>				
								<td>${u.wxName }</td>
								<td>${u.wxCode }</td>
								<td>${u.wxType }</td>
								<td>${u.token }</td>
								<td>
									<a href="${pageContext.request.contextPath }/manager/updatePreUserWeiXin.action?id=${u.userWeiXinId}">编辑</a>
									<a href="${pageContext.request.contextPath }/manager/deleteUserWeiXin.action?id=${u.userWeiXinId}">删除</a>
									<span class="alert-danger">${msg }</span>
									<a href="${pageContext.request.contextPath }/manager/functionManager.action?id=${u.userWeiXinId}">
										<button type="button" class="btn btn-info">功能管理</button>
									</a>
									<a href="${pageContext.request.contextPath }/manager/help.action?id=${u.userWeiXinId}">
										<button type="button" class="btn btn-success">API接口</button>
									</a>									
								</td>
							</tr>
						</c:forEach>
					</tbody>				
				</table>
				<div>
	        		<pg:navigation url="${pageContext.request.contextPath }/manager/showUserWeiXin.action" pageUtil="${paging}"/>			
				</div>
			</c:if>
		</div>
		
	</div>
	
</div>
</body>
</html>
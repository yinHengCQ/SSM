<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	<div class="left-nav col-md-2">
		<c:if test="${empty userWeiXinId }">
			<div class="list-group">
				<span class="list-group-item active">
					<h4 class="list-group-item-heading">
						用户信息
					</h4>
				</span>
				<span class="list-group-item">
					<h4 class="list-group-item-heading">
						用户状态
					</h4>
					<p class="list-group-item-text">
						${sessionScope.userInfo.state }
					</p>
				</span>
				<span class="list-group-item">
					<h4 class="list-group-item-heading">
						注册时间
					</h4>
					<p class="list-group-item-text">
						${sessionScope.userInfo.regTime }
					</p>
				</span>
				<span class="list-group-item">
					<h4 class="list-group-item-heading">
						到期时间
					</h4>
					<p class="list-group-item-text">
						${sessionScope.userInfo.endTime }
					</p>
				</span>			
			</div>
		</c:if>	
		
		<c:if test="${not empty userWeiXinId }">
			<div class="list-group">
				<span class="list-group-item active">
					<h4 class="list-group-item-heading">
						功能管理
					</h4>
				</span>			
				<a href="${pageContext.request.contextPath }/manager/showReply.action" class="list-group-item">
					<p class="list-group-item-text">
						回复管理
					</p>
				</a>
				<a href="${pageContext.request.contextPath }/manager/showCategory.action" class="list-group-item">
					<p class="list-group-item-text">
						分类管理
					</p>
				</a>
				<a href="${pageContext.request.contextPath }/manager/showSlideAdvs.action" class="list-group-item">
					<p class="list-group-item-text">
						幻灯片
					</p>
				</a>
				<a href="${pageContext.request.contextPath }/manager/showSlideAdvsUI.jsp" class="list-group-item">
					<p class="list-group-item-text">
						幻灯片UI
					</p>
				</a>				
				<a href="${pageContext.request.contextPath }/manager/showArticle.action" class="list-group-item">
					<p class="list-group-item-text">
						文章管理
					</p>
				</a>
			</div>
			<div class="list-group">
				<span class="list-group-item active">
					<h4 class="list-group-item-heading">
						手机效果
					</h4>
				</span>	
				<a href="${pageContext.request.contextPath }/weChart/showTemplet.do" class="list-group-item">
					<p class="list-group-item-text">
						模板管理
					</p>
				</a>				
<%-- 				<a href="${pageContext.request.contextPath }/weChart/addPreTemplet.do" class="list-group-item">
					<p class="list-group-item-text">
						添加模板
					</p>
				</a> --%>												
			</div>			
		</c:if>		
	</div>	

</body>
</html>
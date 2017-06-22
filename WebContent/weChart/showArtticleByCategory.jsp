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
	<div class="container">
		<c:forEach items="${paging.data }" var="a">
			<dir class="col-md-12">
				<div class="col-md-4">
					<a href=<c:choose><c:when test="${a.articleUrl.startsWith('http') }">"${a.articleUrl }"</c:when>
							<c:otherwise>"${pageContext.request.contextPath }/weChart/showArticleContext.do?id=${a.articleId }"</c:otherwise></c:choose>>
						<img src="${a.articleImage }" width="300" height="200">
					</a>				
				</div>
				<div class="col-md-8">
					${a.title }
				</div>
			</dir>
		</c:forEach>	
	</div>
</body>
</html>
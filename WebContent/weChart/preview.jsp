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
		<dir class="col-md-12 col-sm-12">
			<center>
				<div id="myCarousel" class="carousel slide">
					<!-- 轮播（Carousel）指标 -->
					<ol class="carousel-indicators">
						<c:forEach items="${list_slideAdvs }" var="s">
							<li data-target="#myCarousel" data-slide-to="${list_slideAdvs.indexOf(s) }" <c:if test="${list_category.get(0)==s }">class="active"</c:if>></li>
						</c:forEach>
					</ol>   
					<!-- 轮播（Carousel）项目 -->
					<div class="carousel-inner">
						<c:forEach items="${list_slideAdvs }" var="s">
							<div class="item <c:if test="${list_slideAdvs.get(0)==s }">active</c:if>">
								<a href="${s.advsUrl }">
									<img src="${s.advsImage }" alt="First slide" width="500" height="280">
								</a>			
							</div>						
						</c:forEach>	
					</div>
					<!-- 轮播（Carousel）导航 -->
					<a class="carousel-control left" href="#myCarousel" 
					   data-slide="prev">&lsaquo;</a>
					<a class="carousel-control right" href="#myCarousel"
					   data-slide="next">&rsaquo;</a>
				</div>
			</center>		
		</dir>
		<c:forEach items="${list_category }" var="c">
			<dir class="col-md-4 col-sm-4">
				<center>
					<a href="${c.cateUrl }">
						<img src="${c.cateImage }" width="300" height="180">
					</a>				
				</center>
			</dir>
		</c:forEach>
	</div>
</body>
</html>
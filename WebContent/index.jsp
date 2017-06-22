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
<div class="back-index">
	<%@include file="/manager/common/top_nav.jsp" %>	
	
	<div class="index">
		<center>
			<div id="myCarousel" class="carousel slide">
				<!-- 轮播（Carousel）指标 -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
					<li data-target="#myCarousel" data-slide-to="3"></li>
				</ol>   
				<!-- 轮播（Carousel）项目 -->
				<div class="carousel-inner">
					<div class="item active">
						<img src="${pageContext.request.contextPath }/image/1.jpg" alt="First slide">
	
					</div>
					<div class="item">
						<img src="${pageContext.request.contextPath }/image/2.jpg" alt="Second slide">
						
					</div>
					<div class="item">
						<img src="${pageContext.request.contextPath }/image/3.jpg" alt="Third slide">
						
					</div>
					<div class="item">
						<img src="${pageContext.request.contextPath }/image/4.jpg" alt="Third slide">
						
					</div>			
				</div>
				<!-- 轮播（Carousel）导航 -->
				<a class="carousel-control left" href="#myCarousel" 
				   data-slide="prev">&lsaquo;</a>
				<a class="carousel-control right" href="#myCarousel"
				   data-slide="next">&rsaquo;</a>
			</div>
		</center>
	</div>	
	
	<div class="index-bottom col-md-offset-1 col-md-10">
		<h2>微信营销管后台理系统是什么?</h2>
		<p>微信营销管后台理系统又称
		<strong>微信营销商家管理系统</strong>，是一款中小企业微信营销商家管理系统，您只要简单的配置就可以完成 自定义回复，
		微信网站，微信房产，微信商城，微信团购，微信优惠券，微信订餐，微信营销等复杂的功能。我们志在帮助那些不懂技术的个人或中
		小企业通过简单的配置，即可拥有强大的微信营销展示程序。
		</p>
	</div>
	
</div>
</body>
</html>
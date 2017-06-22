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

	<nav class="navbar navbar-default navbar-fixed-top" role="navigation"> 
	    <div class="container-fluid"> 
		    <div class="navbar-header col-md-3"> 
		        <label class="navbar-brand" style="color: white;">微信商家营销管理系统</label> 
		    </div> 
		    <div class="navbar-header col-md-7"> 
		        <ul class="nav navbar-nav"> 
		            <li> 
		                <a style="color: white;" href="${pageContext.request.contextPath }/index.jsp"> 
		                   	首页 
		                </a> 
		            </li> 		        
		            <li> 
		                <a style="color: white;" href="${pageContext.request.contextPath }/manager/backToShowUserWeiXin.action"> 
		                   	 功能首页 
		                </a> 
		            </li> 
		            <li> 
		                <a style="color: white;" href="#"> 
		               		 功能介绍 
		                </a> 
		            </li> 
		            <li> 
		                <a style="color: white;" href="#"> 
		               		 关于我们 
		                </a> 
		            </li> 	
		            <li> 
		                <a style="color: white;" href="#"> 
		               		 帮助中心
		                </a> 
		            </li> 	                        
		        </ul> 
		    </div>
		    <div class="index-login col-md-2">
		    	<ul class="nav navbar-nav">
		    		<c:if test="${null==userInfo }">
			    		<li>
			    			<a href="${pageContext.request.contextPath }/manager/login.jsp">
								<button type="button" class="btn btn-default navbar-btn">
									登录
					  			</button>
			    			</a>
			    		</li> 
			    		<li>
			    			<a href="${pageContext.request.contextPath }/manager/register.jsp">
								<button type="button" class="btn btn-default navbar-btn">
									注册
					  			</button>
			    			</a>
			    		</li> 		    		
		    		</c:if>
		    		<c:if test="${null!=userInfo }">
		    			<li style="width: 100px">
		    				<span style="color: white;position: relative;top: 15px;">
			    				您好！${userInfo.loginName }
		    				</span>
		    			</li>
			    		<li>
			    			<a href="${pageContext.request.contextPath }/manager/out.action">
								<button type="button" class="btn btn-default navbar-btn">
									退出
					  			</button>
			    			</a>
			    		</li>		    			
		    		</c:if>
		    	</ul> 
		    </div>     
	    </div> 
	</nav>		

</body>
</html>
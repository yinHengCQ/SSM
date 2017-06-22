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
	
	<div class="login">
		<form method="post" class="form-horizontal myForm" action="${pageContext.request.contextPath }/manager/register.action">
			<div class="form-group login-form-group">
				<label class="col-md-2 control-label">登录名：</label>
				<div class="col-md-4">
					<input class="form-control" type="text" name="loginName">
				</div>
			</div>		
			<div class="form-group login-form-group">
				<label class="col-md-2 control-label">密码：</label>
				<div class="col-md-4">
					<input class="form-control" type="text" name="loginPwd">
				</div>
			</div>	
			<div class="form-group login-form-group">
				<label class="col-md-2 control-label">验证码：</label>
				<div class="col-md-4">
					<input class="form-control" type="text" name="vcode">
				</div>
			</div>	
			<div class="form-group login-form-group">
				<div class="col-md-offset-2 col-md-4">
					<img src="${pageContext.request.contextPath }/manager/getVerifyCode.action" align="left" title="看不清，点击换一张" onClick="this.src=this.src+'?'"/>
					<label style="margin-top: 6px">
						看不清?，点击换一张
					</label>
				</div>	
			</div>					
			<div class="form-group login-form-group">
				<div class="col-md-offset-2 col-md-4">
					<button type="submit" class="btn btn-success">注册</button>
					<span class="alert-danger">${msg }</span>
				</div>
			</div>		

		</form>
	</div>	
</div>	
</body>
</html>
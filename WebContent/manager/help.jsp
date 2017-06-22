<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>如何接入微信公众号</title>
<style type="text/css">
.content {
	padding: 20px;
	width: 960px;
	margin: 0 auto;
	border: 1px solid #c7cdd6;
	background: #FFF;
	box-shadow: 0px 1px 3px #ccc;
}

.content h1 {
	font-size: 20px;
	text-align: center;
	display: block;
	margin-top: 20px;
}

.content .info {
	text-align: center;
	font-size: 14px;
	color: #999;
	margin: 10px 0;
	padding-bottom: 20px;
	border-bottom: 1px solid #EEE;
}

.content .introduce {
	background: #F4F4F4;
	border: 1px dotted #ccc;
	padding: 20px;
	margin: 20px 0;
	color: #333;
}

#article {
	border: none;
	padding: 0px;
	box-shadow: none;
	font-size: 14px;
}

.content .np {
	font-size: 12px;
	border-top: 1px solid #EEE;
	padding-top: 10px;
	margin-bottom: 20px;
}

.content .np li {
	height: 30px;
	line-height: 30px;
}

.content .inrobt {
	font-size: 12px;
	text-align: center;
	background: #EEE;
	height: 30px;
	line-height: 30px;
	color: #666;
	margin-bottom: 20px;
}
</style>
</head>
<body>
<div class="back">
	<%@include file="/manager/common/top_nav.jsp" %>
	
	
	<div class="main">
		<%@include file="/manager/common/left_nav.jsp" %>
		
		<div class="main-roght col-md-10">

	<div class="content" style="width: 985px;">
		<div class="document" style="margin-top: 0px;">
			<div class="normalTitle">
				<h2>如何为微信公众号配置接口？</h2>
			</div>
			<div class="collapsible">
				<div class="section lastSection">
					<p>
						请务必认真阅读以下2步内容，才能更有效的完成配置工作，有疑问的请联系QQ：qq群：240840349提问。<br>你的接口URL是：<font
							color="red">${pageContext.request.contextPath}/index.jsp?g=Home&amp;m=Weixin&amp;a=index&amp;token=${userWeiXin.token }</font><br>您的token是：<font
							color="red">${userWeiXin.token }</font>
					</p>
				</div>
				<div id="CollapsiblePanel2" class="CollapsiblePanel">
					<div class="CollapsiblePanelTab clicked">
						第一步、在微信营销后台管理系统_中小企业微信营销商家管理系统绑定你的微信公众号。<span></span>
					</div>
					<div style="" class="">
						<div class="articleContent catalogHome normalContent">
							<div class="section lastSection">
								<p>
									1、注册并登录<a href="/index.php?m=Index&amp;a=login">微信营销后台管理系统_中小企业微信营销商家管理系统接口平台</a>
								</p>
								<p>2、添加公众号 → 功能管理 → 勾选要开启的功能</p>
								<p>
									<img src="./tpl/static/help/help01.jpg" width="790px">
								</p>
								<p>
									<img src="./tpl/static/help/help0.jpg" width="790px">
								</p>
							</div>
						</div>
					</div>
				</div>
				<div id="CollapsiblePanel3" class="CollapsiblePanel">
					<div class="CollapsiblePanelTab clicked">
						第二步、到微信公众平台设置接口。<span></span>
					</div>
					<div style="" class="">
						<div class="articleContent catalogHome normalContent">
							<div class="section lastSection">
								<div class="section lastSection">
									<p>
										1、登录 <a href="http://mp.weixin.qq.com/">微信公众平台</a>（<a
											href="http://mp.weixin.qq.com/">http://mp.weixin.qq.com/</a>），进行身份认证，填写信息，提交身份证。
									</p>
									<p>认证后，点击高级功能 → 进入开发模式</p>
									<br>
									<p>
										<img src="${pageContext.request.contextPath }/image/help/help002.jpg" width="790px">
									</p>
									<br>
									<p>2、点击"成为开发者"按钮</p>
									<p>
										<img src="${pageContext.request.contextPath }/image/help/help003.jpg" width="790px">
									</p>
									<br>
									<p>3、填写接口配置信息</p>
									<p>
										你的URL是 <font color="red">${pageContext.request.contextPath}/index.jsp?g=Home&amp;m=Weixin&amp;a=index&amp;token=${userWeiXin.token }</font>
									</p>
									<p>
										Token填写 <font color="red">${userWeiXin.token }</font>
									</p>
									<br>

									<p>
										<font style="color: red;">Url地址以后台获取的为准</font>
									</p>
									<br>

									<p>
										<img src="${pageContext.request.contextPath }/image/help/help004.jpg" width="790px">
									</p>
									<br>
									<p>4、确认开启</p>
									<p>5、在手机上用微信给你的公众号输入"帮助"，测试你的接口是否配置正常！</p>
									<br>
								</div>

							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>

		</div>
		
	</div>
	
</div>
</body>
</html>
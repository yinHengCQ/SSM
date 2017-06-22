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
<link href="${pageContext.request.contextPath }/dialog/skins/default.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/dialog/source/artDialog.js"></script>
<script type="text/javascript">
	$(function(){
		$(".preview").click(function(){
			$(".preview").attr("target","_blank");
		})
		
	})
</script>
</head>
<body>
<div class="back">
	<%@include file="/manager/common/top_nav.jsp" %>
	
	
	<div class="main">
		<%@include file="/manager/common/left_nav.jsp" %>
		
		<div class="main-roght col-md-10">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>模板名称</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>	
					<c:forEach items="${paging.data }" var="r">
						<tr>			
							<td>${r.templetName }</td>
							<td>
								<a class="preview" href="${pageContext.request.contextPath }/weChart/preview.do?id=${r.templetId}">预览</a>
								<a href="${pageContext.request.contextPath }/weChart/deleteTemplet.do?id=${r.templetId}">删除</a>
								<span class="alert-danger">${msg }</span>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div>
        		<pg:navigation url="${pageContext.request.contextPath }/weChart/showTemplet.do" pageUtil="${paging}"/>			
			</div>
			
		</div>
		
	</div>

</div>	
</body>
</html>
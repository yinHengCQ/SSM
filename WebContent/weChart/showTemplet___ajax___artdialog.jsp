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
		art.dialog({
			title:"预览",
			content:"<div id='tab'></div>"
		})
	})

	
	$(".preview").click(function(){
		$.ajax({
			type:"get",
			url:"${pageContext.request.contextPath }/weChart/previewByJson.do?id="+$(this).attr("templetId"),
			dataType:"json",
			success:function(data){
				var tab=$("#tab");
				var str="<dir class='col-md-12 col-sm-12'>"+
				"<center>"+
					"<div id='myCarousel' class='carousel slide'>"+						
						"<div class='carousel-inner'>";

				for(var i=0;i<data[0].length;i++){
					var obj=data[0][i];
					str+="<div class='item <c:if test='${"+data[0][0]+"==s }'>active</c:if>'>";
					str+="<a href='"+obj.advsUrl+"'>";
					str+="<img src='"+obj.advsImage+"' alt='First slide' width='500' height='280'>";
					str+="</a></dir>";
					tab.append(str);
				}
				tab.append("</dir></dir></center></dir>")
				
				for(var i=0;i<data[1].length;i++){
					var obj=data[1][i];
					var str2="<dir class='col-md-4 col-sm-4'><center>";
					str2+="<a href='"+obj.cateUrl+"'>";
					str2+="<td><img src='"+obj.cateImage+"' width='300' height='180'></td>";
					str2+="</a></center></dir>";
					tab.append(str2);
				}
			},
			error:function(er){
					console.log(er)
			}
		})
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
								<button class="btn preview" templetId="${r.templetId }" type="button">在线预览</button>
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
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
		
		
		$("#addTemplet").click(function(){
			$.ajax({
				type:"get",
				url:"${pageContext.request.contextPath }/weChart/addPreTempletByJson.do",
				dataType:"json",
				success:function(data){
					var tab3=$("#tab3");
					for(var i=0;i<data[3].length;i++){
						var obj=data[3][i];
						var str3="<div class='checkbox'>";
						str3+="<label><input type='checkbox' name='list_slideAdvs' value='"+obj.slideAdvsId+"'/>";
						str3+=obj.advsName+"</label>";
						str3+="</div>";				
						tab3.append(str3);
						console.log(data[3].length)
					}

					var tabs=$(".tabs");
					for(var i=0;i<data[1].length;i++){
						var obj=data[1][i];
						var str="<option value='"+obj.cateId+"'>"+obj.cateName+"</option>";
						tabs.append(str);
						console.log(str)
					}
				}
			})
		})
		
		
		$("#addTemplet").click(function(){
			art.dialog({
				title:"添加模板",
		        content: "<form method='post' class='form-horizontal myForm' action='${pageContext.request.contextPath }/weChart/addTemplet.do'>"+
				
				"<div class='form-group col-md-5'>"+
					"<input class='form-control col-md-5' type='text' name='templetName' placeholder='输入新增模板名称'>"+
				"</div>"+
				"<div class='form-group col-md-offset-2 col-md-3'>"+
					"<input class='btn btn-success' type='submit' value='提交该模板'>"+			
				"</div>"+
					
				"<div class='col-md-offset-1 col-md-9'>"+
					"<input type='hidden' name='userWeiXinId' value='${userWeiXinId }'>"+
					"<dir class='form-group moblieManager-slideAdvs col-md-12'>"+
						"<label>勾选要播放的幻灯片</label><div id='tab3'></div>"+
						"</dir>"+
						"<div class='form-group moblieManager-category col-md-4'>"+
							"<label>请选择分类</label>"+
							"<select class='form-control tabs' name='category1'>"+
							"</select>"+			
						"</div>"+
						"<div class='form-group moblieManager-category col-md-4'>"+
						"<label>请选择分类2</label>"+
						"<select class='form-control tabs' name='category2'>"+
						"</select>"+			
					"</div>"+
					"<div class='form-group moblieManager-category col-md-4'>"+
						"<label>请选择分类3</label>"+
						"<select class='form-control tabs' name='category3'>"+
						"</select>"+			
					"</div>"+	
					"<div class='form-group moblieManager-category col-md-4'>"+
						"<label>请选择分类4</label>"+
						"<select class='form-control tabs' name='category4'>"+
						"</select>"+			
					"</div>"+
					"<div class='form-group moblieManager-category col-md-4'>"+
						"<label>请选择分类5</label>"+
						"<select class='form-control tabs' name='category5'>"+
						"</select>"+			
					"</div>"+
					"<div class='form-group moblieManager-category col-md-4'>"+
						"<label>请选择分类6</label>"+
						"<select class='form-control tabs' name='category6'>"+
						"</select>"+			
					"</div>"+
				"</div>"+	
			"</form>"						
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
			<button id="addTemplet" type="button" class="btn btn-success">添加模板</button>
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
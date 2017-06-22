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
</head>
<body>
	<%@include file="/manager/common/top_nav.jsp" %>
	<div class="main">
		<%@include file="/manager/common/left_nav.jsp" %>
		<div class="main-roght col-md-10" style="padding-top: 10px">
			<form method="post" class="form-horizontal myForm" action="${pageContext.request.contextPath }/weChart/addTemplet.do">
				
				<div class="form-group col-md-5">
					<input class="form-control col-md-5" type="text" name="templetName" placeholder="输入新增模板名称">
				</div>
				<div class="form-group col-md-offset-2 col-md-3">
					<input class="btn btn-success" type="submit" value="提交该模板">			
				</div>
					
				<div class="col-md-offset-1 col-md-9">
					<input type="hidden" name="userWeiXinId" value="${userWeiXinId }">
					<dir class="form-group moblieManager-slideAdvs col-md-12">
						<label>勾选要播放的幻灯片</label>			
						<c:forEach items="${list_slideAdvs }" var="l">	
							<div class="checkbox">
								<label><input type="checkbox" name="list_slideAdvs" value="${l.slideAdvsId }"/>${l.advsName }</label>
							</div>	
						</c:forEach>
					</dir>
					<div class="form-group moblieManager-category col-md-4">
						<label>请选择分类1</label>
						<select class="form-control" name="category1">
							<c:forEach items="${list_category }" var="l">
								<option value="${l.cateId }">${l.cateName }</option>
							</c:forEach>
						</select>			
					</div>
					<div class="form-group moblieManager-category col-md-4">
						<label>请选择分类2</label>
						<select class="form-control" name="category2">
							<c:forEach items="${list_category }" var="l">
								<option value="${l.cateId }">${l.cateName }</option>
							</c:forEach>
						</select>			
					</div>
					<div class="form-group moblieManager-category col-md-4">
						<label>请选择分类3</label>
						<select class="form-control" name="category3">
							<c:forEach items="${list_category }" var="l">
								<option value="${l.cateId }">${l.cateName }</option>
							</c:forEach>
						</select>			
					</div>	
					<div class="form-group moblieManager-category col-md-4">
						<label>请选择分类4</label>
						<select class="form-control" name="category4">
							<c:forEach items="${list_category }" var="l">
								<option value="${l.cateId }">${l.cateName }</option>
							</c:forEach>
						</select>			
					</div>
					<div class="form-group moblieManager-category col-md-4">
						<label>请选择分类5</label>
						<select class="form-control" name="category5">
							<c:forEach items="${list_category }" var="l">
								<option value="${l.cateId }">${l.cateName }</option>
							</c:forEach>
						</select>			
					</div>
					<div class="form-group moblieManager-category col-md-4">
						<label>请选择分类6</label>
						<select class="form-control" name="category6">
							<c:forEach items="${list_category }" var="l">
								<option value="${l.cateId }">${l.cateName }</option>
							</c:forEach>
						</select>			
					</div>
				</div>	
			</form>	
			
			
			<div>
				<button id="btn" type="button" class="btn">dialog</button>
			</div>
		
		
		</div>
	</div>

<script type="text/javascript">
$("#btn").click(function () {
    art.dialog({
        title: "这是框体标题",
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
				"<label>+勾选要播放的幻灯片</label>"+			
				"<c:forEach items='${list_slideAdvs }' var='l'>"+	
					"<div class='checkbox'>"+
						"<label><input type='checkbox' name='list_slideAdvs' value='${l.slideAdvsId }'/>${l.advsName }</label>"+
					"</div>"+	
				"</c:forEach>"+
			"</dir>"+
			"<div class='form-group moblieManager-category col-md-4'>"+
				"<label>请选择分类</label>"+
				"<select class='form-control' name='category1'>"+
					"<c:forEach items='${list_category }' var='l'>"+
						"<option value='${l.cateId }'>${l.cateName }</option>"+
					"</c:forEach>"+
				"</select>"+			
			"</div>"+
			"<div class='form-group moblieManager-category col-md-4'>"+
				"<label>请选择分类2</label>"+
				"<select class='form-control' name='category2'>"+
					"<c:forEach items='${list_category }' var='l'>"+
						"<option value='${l.cateId }'>${l.cateName }</option>"+
					"</c:forEach>"+
				"</select>"+			
			"</div>"+
			"<div class='form-group moblieManager-category col-md-4'>"+
				"<label>请选择分类3</label>"+
				"<select class='form-control' name='category3'>"+
					"<c:forEach items='${list_category }' var='l'>"+
						"<option value='${l.cateId }'>${l.cateName }</option>"+
					"</c:forEach>"+
				"</select>"+			
			"</div>"+	
			"<div class='form-group moblieManager-category col-md-4'>"+
				"<label>请选择分类4</label>"+
				"<select class='form-control' name='category4'>"+
					"<c:forEach items='${list_category }' var='l'>"+
						"<option value='${l.cateId }'>${l.cateName }</option>"+
					"</c:forEach>"+
				"</select>"+			
			"</div>"+
			"<div class='form-group moblieManager-category col-md-4'>"+
				"<label>请选择分类5</label>"+
				"<select class='form-control' name='category5'>"+
					"<c:forEach items='${list_category }' var='l'>"+
						"<option value='${l.cateId }'>${l.cateName }</option>"+
					"</c:forEach>"+
				"</select>"+			
			"</div>"+
			"<div class='form-group moblieManager-category col-md-4'>"+
				"<label>请选择分类6</label>"+
				"<select class='form-control' name='category6'>"+
					"<c:forEach items='${list_category }' var='l'>"+
						"<option value='${l.cateId }'>${l.cateName }</option>"+
					"</c:forEach>"+
				"</select>"+			
			"</div>"+
		"</div>"+	
	"</form>"+	
	"<div>"+
		"<button id='btn' type='button' class='btn'>dialog</button>"+
	"</div>"
    });
});
</script>


						

</body>
</html>
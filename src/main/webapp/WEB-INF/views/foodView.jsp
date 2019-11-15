<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SafeFood::상세정보</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet" type="text/css">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script src="<c:url value="/resources/js/button.js"/>"></script>
<script src="<c:url value="/resources/js/init.js"/>"></script>

<script type="text/javascript">
	google.charts.load('current', {'packages':['corechart']});
	
	google.charts.setOnLoadCallback(function(){
		var a = ${food.nutrition.callory};
		var b = ${food.nutrition.carbo};
		var c = ${food.nutrition.protein};
		var d = ${food.nutrition.fat};
		var e = ${food.nutrition.sugars};
		var f = ${food.nutrition.natrium};
		var g = ${food.nutrition.cholesterol};
		var h = ${food.nutrition.saturatedFattyAcid};
		var i = ${food.nutrition.transFat};
						
		var data = google.visualization.arrayToDataTable([
				['Nutrition', 'Nutrition per Production'],
				['칼로리', parseFloat(a)],
				['탄수화물', parseFloat(b)],
				['단백질', parseFloat(c)],
				['지방', parseFloat(d)],
				['당류', parseFloat(e)],
				['나트륨', parseFloat(f)],
				['콜레스테롤', parseFloat(g)],
				['포화지방산', parseFloat(h)],
				['트랜스지방', parseFloat(i)]
		]);
						
		var options = {'title':'영양 정보','width':500,'height':300};
		var chart = new google.visualization.PieChart(document.getElementById('piechart'));
		chart.draw(data, options);
	});
</script>

</head>
<body>
	<header>
		<jsp:include page="../../header.jsp" flush="true"/>
	</header>
	
	<nav>
		<jsp:include page="../../nav.jsp" flush="true"/>
	</nav>
	
	<div class="banner">
		<div class="banner-top">
			<div class="title-one">상세정보</div>
			<div class="title-two">건강한 삶을 위한 먹거리 프로젝트</div>
		</div>
	</div>
	
	<section>
		<div class="view-table-board">
			<table>
				<tr>
					<td rowspan="6" class="table-img">
						<img src="resources/${food.imgurl}" width="300px">
					</td>
				</tr>
				<tr class="table-row">
					<th>제품명</th>
					<td>${food.foodName}</td>
				</tr>
				<tr class="table-row">
					<th>제조사</th>
					<td>${food.maker}</td>
				</tr>
				<tr class="table-row">
					<th>원재료</th>
					<td>
					<c:forEach var="mat" items="${food.materialList}" varStatus="i">
							${mat.mat}
							<c:if test="${i.count != food.materialList.size()}">, </c:if>
					</c:forEach>
					</td>
				</tr>
				<tr class="table-row">
					<th>알레르기성분</th>
					<td>
					<c:choose>
						<c:when test="${sessionScope.member != null}">
							<c:forEach var="mat" items="${mSet}" varStatus="i">
								${mat.mat}
								<c:if test="${i.count != mSet.size()}">,</c:if> 
							</c:forEach>
						</c:when>
						<c:otherwise>
							로그인이 필요한 서비스입니다.
						</c:otherwise>
					</c:choose>
					</td>
				</tr>
				<tr class="table-row">
					<th>Quantity</th>
					<td class="table-quantity">
						<c:choose>
							<c:when test="${sessionScope.member != null}">
								<div class="quantity-set">
									<input type="number" id="quantity" value="1">
									<div class="up-down-btns">
										<i class="fas fa-chevron-up" id="up-btn"></i> 
										<i class="fas fa-chevron-down" id="down-btn"></i>
									</div>
									<button class="quantity-update-ingestion" id="${food.foodName}">추가</button>
									<button class="quantity-update-likes" id="${food.foodName}">찜</button>
								</div>
							</c:when>
							<c:otherwise>
								로그인이 필요한 서비스입니다.
							</c:otherwise>
						</c:choose>

					</td>
				</tr>
			</table>
		</div>
		
		<div class="nutrition-board">
			<table>
				<tr class="table-graph">
					<td rowspan="11" id="piechart"></td>
				</tr>
				<tr class="chart-row">
					<th>일일 제공량</th>
					<td>${food.nutrition.dailyServing}</td>
				</tr>
				<tr class="chart-row">
					<th>칼로리</th>
					<td>${food.nutrition.callory}</td>
				</tr>
				<tr class="chart-row">
					<th>탄수화물</th>
					<td>${food.nutrition.carbo}</td>
				</tr>
				<tr class="chart-row">
					<th>단백질</th>
					<td>${food.nutrition.protein}</td>
				</tr>
				<tr class="chart-row">
					<th>지방</th>
					<td>${food.nutrition.fat}</td>
				</tr>
				<tr class="chart-row">
					<th>당류</th>
					<td>${food.nutrition.fat}</td>
				</tr>
				<tr class="chart-row">
					<th>지방</th>
					<td>${food.nutrition.sugars}</td>
				</tr>
				<tr class="chart-row">
					<th>나트륨</th>
					<td>${food.nutrition.natrium}</td>
				</tr>
				<tr class="chart-row">
					<th>콜레스테롤</th>
					<td>${food.nutrition.saturatedFattyAcid}</td>
				</tr>
				<tr class="chart-row">
					<th>트랜스지방</th>
					<td>${food.nutrition.transFat}</td>
				</tr>
			</table>
		</div>
		<button onclick="backPage()">뒤로가기</button>
	</section>
	
	<footer>
		<jsp:include page="../../footer.jsp" flush="true"/>
	</footer>
</body>
</html>
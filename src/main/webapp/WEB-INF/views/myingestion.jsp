<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SafeFood::내 섭취 정보</title>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script src="<c:url value="/resources/js/button.js"/>"></script>
<script src="<c:url value="/resources/js/init.js"/>"></script>

</head>
<body>
	<header>
		<jsp:include page="../../header.jsp" flush="true" />
	</header>

	<nav>
		<jsp:include page="../../nav.jsp" flush="true" />
	</nav>

	<div class="banner">
		<div class="banner-top">
			<div class="title-one">내 섭취 정보</div>
			<div class="title-two">건강한 삶을 위한 먹거리 프로젝트</div>
		</div>
	</div>

	<section>
		<div class="my-intake-board">
			<form action="deleteIngestion.do" method="post" onsubmit="retrun check">
				<table>
					<tr>
						<th class="ingestion-img">이미지</th>
						<th class="ingestion-name">이름</th>
						<th class="ingestion-quantity">수량</th>
						<th class="ingestion-allergy">알레르기</th>
						<th class="ingestion-delete">삭제</th>
					</tr>
					<c:forEach var="ingestion" items="${ingestionList}" varStatus="i">
						<tr>
							<td class="ingestion-img-el"><img
								src="./resources/${ingestion.food.imgurl}" width="100"
								height="100"></td>
							<td class="ingestion-name-el">${ingestion.food.foodName}</td>
							<td class="ingestion-quantity-el">
								<div class="quantity-el-set">
									<span><i class="fas fa-chevron-up ingestion-up-btn"></i></span>
									<span id="quantity">${ingestion.quantity}</span>
									<span><i class="fas fa-chevron-down ingestion-down-btn"></i></span>
								</div>
								<input type="button" class = "ingestion-update-btn" id="${ingestion.food.foodName}" value="변경">
							</td>
							<td class="ingestion-allergy-el">
							<c:forEach var="material" items="${mSet}">
								<c:if test="${material.foodName == ingestion.food.foodName}">
									${material.mat}
								</c:if>
							</c:forEach>
							</td>
							<td class="ingestion-delete-el">
								<input type="checkbox" name="deleteCheck" value="${ingestion.food.foodName}">
							</td>
						</tr>
					</c:forEach>
				</table>
				<div class="ingestion-btns">
					<input type="submit" value="삭제">
				</div>
			</form>

		</div>

		<div class="table-nutrition">
			<div class="recommand-nutrition">
				<h2>1일 권장량</h2>
				<table border="1">
					<tr>
						<th>칼로리</th>
						<td>2000</td>
					</tr>
					<tr>
						<th>탄수화물</th>
						<td>328</td>
					</tr>
					<tr>
						<th>단백질</th>
						<td>60</td>
					</tr>
					<tr>
						<th>지방</th>
						<td>50</td>
					</tr>
					<tr>
						<th>당류</th>
						<td>100</td>
					</tr>
					<tr>
						<th>나트륨</th>
						<td>2000</td>
					</tr>
					<tr>
						<th>콜레스테롤</th>
						<td>300</td>
					</tr>
					<tr>
						<th>포화지방산</th>
						<td>15</td>
					</tr>
					<tr>
						<th>트랜스지방</th>
						<td>2.9</td>
					</tr>
				</table>
			</div>
			<div class="my-nutrition">
				<h2>나의 섭취량</h2>
				<table border="1">
					<tr>
						<th>총 칼로리</th>
						<td>${total.callory}</td>
					</tr>
					<tr>
						<th>탄수화물</th>
						<td>${total.carbo}</td>
					</tr>
					<tr>
						<th>단백질</th>
						<td>${total.protein}</td>
					</tr>
					<tr>
						<th>지방</th>
						<td>${total.fat}</td>
					</tr>
					<tr>
						<th>당류</th>
						<td>${total.sugars}</td>
					</tr>
					<tr>
						<th>나트륨</th>
						<td>${total.natrium}</td>
					</tr>
					<tr>
						<th>콜레스테롤</th>
						<td>${total.cholesterol}</td>
					</tr>
					<tr>
						<th>포화지방산</th>
						<td>${total.saturatedFattyAcid}</td>
					</tr>
					<tr>
						<th>트랜스지방</th>
						<td>${total.transFat}</td>
					</tr>
				</table>
			</div>
		</div>

	</section>

	<footer>
		<jsp:include page="../../footer.jsp" flush="true" />
	</footer>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SafeFood::베스트 섭취 정보</title>
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
			<div class="title-one">베스트 섭취 정보</div>
			<div class="title-two">건강한 삶을 위한 먹거리 프로젝트</div>
		</div>
	</div>

	<section>
		<div class="my-intake-board">
				<table>
					<tr>
						<th>순위</th>
						<th class="ingestion-img">이미지</th>
						<th class="ingestion-name">이름</th>

					</tr>
					<c:forEach var="best" items="${bestList}" varStatus="i">
						<tr>
							<td>${i.count}</td>
							<td class="ingestion-img-el"><img
								src="./resources/${best.imgurl}" width="100"
								height="100"></td>
							<td class="ingestion-name-el">${best.foodName}</td>
						</tr>
					</c:forEach>
				</table>
		</div>
	</section>

	<footer>
		<jsp:include page="../../footer.jsp" flush="true" />
	</footer>
</body>
</html>
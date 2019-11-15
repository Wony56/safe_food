<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SafeFood::메인 페이지</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
<link href='<c:url value="./resources/css/style.css"/>' rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.4.0.min.js" ></script>
<script src="<c:url value="/resources/js/button.js"/>"></script>
<script src="<c:url value="/resources/js/init.js"/>"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
	<header>
		<jsp:include page="header.jsp" flush="true"/>
	</header>
	
	<nav>
		<jsp:include page="nav.jsp" flush="true"/>
	</nav>
	
	<div class="banner">
		<div class="banner-top">
			<div class="title-one">안전한 먹거리</div>
			<div class="title-two">건강한 삶을 위한 먹거리 프로젝트</div>
		</div>
	</div>
	
	<section>
		
	</section>
	
	<footer>
		<jsp:include page="footer.jsp" flush="true"/>
	</footer>
	
	<script type="text/javascript">
		$('.login-board').hide();
	</script>
</body>
</html>
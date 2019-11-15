<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SafeFood::회원가입</title>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script src="<c:url value="/resources/js/button.js"/>"></script>
<script src="<c:url value="/resources/js/init.js"/>"></script>
<script src="<c:url value="/resources/js/signupInvalid.js"/>"></script>

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
			<div class="title-one">회원가입</div>
			<div class="title-two">회원정보를 입력해주세요</div>
		</div>
	</div>
	
	<section>
		<div class="main-form">
			<form action="signUp.do" method="post" id="test" onsubmit="return invalidCheck()">
				<div class = "input-area">
				<div class="id-input row">
					<div class="id-label label">
						<label >아이디<span>*</span></label>
					</div>
					<div class="id-input-area in-area">
						<input type="text" id="id-up" name="id"/>
					</div>
				</div>
				<div class="pwd-input row">
					<div class="pwd-input-label label">
						<label >비밀번호<span>*</span></label>
					</div>
					<div class="pwd-input-area in-area">
						<input type="password" id="pass-up" name="password"/>
					</div>
				</div>
				<div class="name-input row">
					<div class="name-input-label label">
						<label >이름<span>*</span></label>
					</div>
					<div class="name-input-area in-area">
						<input type="text" id="name" name="name"/>
					</div>
				</div>
				<div class="addr-input row">
					<div class="addr-input-label label">
						<label >주소<span>*</span></label>
					</div>
					<div class="addr-input-area in-area">
						<input type="text" id="addr" name="address"/>
					</div>
				</div>
				<div class="phone-input row">
					<div class="phone-input-label label">
						<label >전화번호<span>*</span></label>
					</div>
					<div class="phone-input-area in-area">
						<input type="text" placeholder="000-0000-0000" maxlength="13" id="cellPhone" name="phone"/>
					</div>
				</div>
				<div class="alergy-input">
					<div class="alergy-label label">
						<label >알레르기</label>
					</div>
					<div class="alergy-selection">
						<fieldset >
							<legend>Check</legend>
							<input type="checkbox" name="allergy" value="대두"/>대두
							<input type="checkbox" name="allergy" value="땅콩"/>땅콩
							<input type="checkbox" name="allergy" value="우유"/>우유
							<input type="checkbox" name="allergy" value="게"/>게
							<br>
							<input type="checkbox" name="allergy" value="새우"/>새우
							<input type="checkbox" name="allergy" value="참치"/>참치
							<input type="checkbox" name="allergy" value="연어"/>연어
							<input type="checkbox" name="allergy" value="쑥"/>쑥
							<br>
							<input type="checkbox" name="allergy" value="소고기"/>소고기
							<input type="checkbox" name="allergy" value="닭고기"/>닭고기
							<input type="checkbox" name="allergy" value="돼지고기"/>돼지고기
							<br>
							<input type="checkbox" name="allergy" value="복숭아"/>복숭아
							<input type="checkbox" name="allergy" value="민들레"/>민들레
							<input type="checkbox" name="allergy" value="계란흰자"/>계란흰자
							<br>
						</fieldset>
					</div>
				</div>
				<div class="sign-up-btn-area row">
					<div class="sign-up">
						<input type="submit" value="가입">
					</div>
				</div>	
			</div>
		</form>
	</div>
		
	</section>
	
	<footer>
		<jsp:include page="footer.jsp" flush="true"/>
	</footer>
</body>
</html>
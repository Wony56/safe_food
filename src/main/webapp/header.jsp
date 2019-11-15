<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="header-menu">
	<div class="home-btn">
		<a href="index.jsp">Safe Food</a>
	</div>
	<div class="member-info">
		<c:choose>
			<c:when test="${sessionScope.member != null }">
				<div class="member-label">${sessionScope.member.name}님반갑습니다.</div>
				<div class="member-btn">
					<button id="memberinfo-btn">회원정보</button>
				</div>
				<div class="member-btn">
					<button id="logout-btn">로그아웃</button>
				</div>
			</c:when>
			<c:otherwise>
				<div class="member-btn">
					<button id="signup-btn">회원가입</button>
				</div>
				<div class="member-btn">
					<button id="login-btn">로그인</button>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<div id="login" class="login-board">
	<form action="logIn.do" method="post">
		<div class="row">
			<div class="row-label">아이디</div>
			<div>
				<input type="text" name="id" required="required">
			</div>
		</div>
		<div class="row">
			<div class="row-label">패스워드</div>
			<div>
				<input type="password" name="password" required="required">
			</div>
		</div>
		<div class="row buttons">
			<button type="submit">로그인</button>
			<button type="button" id="find-pwd">패스워드 찾기</button>
		</div>
	</form>
</div>
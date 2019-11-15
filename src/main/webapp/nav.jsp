<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="nav-menu">
	<div class="notification menu menu-item"><a href="getNoticeList.do">공지사항<span></span><span></span><span></span><span></span></a></div>
	<div class="product-info menu menu-item"><a href="getAllFood.do">상품정보<span></span><span></span><span></span><span></span></a></div>
	<c:if test="${sessionScope.member != null }">
	<div class="best-ingestion menu menu-item"><a href="best.do">베스트 섭취 정보<span></span><span></span><span></span><span></span></a></div>
	<div id="my-ingestion" class="my-ingestion menu menu-item"><a href="ingestionInfo.do">내 섭취 정보<span></span><span></span><span></span><span></span></a></div>
	<div id="pre-ingestion" class="pre-ingestion menu menu-item"><a href="likesInfo.do">예상 섭취 정보<span></span><span></span><span></span><span></span></a></div>
	</c:if>
	<div class="qna menu menu-item"><a href="http://14.46.141.70:7788/qna.html">Q & A<span></span><span></span><span></span><span></span></a></div>
</div>
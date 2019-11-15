<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${foodList == null || foodList.size() == 0 }">
		<h2 align="center">검색결과가 없습니다.</h2>
	</c:when>
	<c:otherwise>
		<c:forEach var="food" items="${foodList}">
			<div class="food-card" id="${food.foodName}">
				<div class="food-img">
					<img src="resources/${food.imgurl}">
					<div class="food-info-hover">
						<div class="food-name-hover">${food.foodName}</div>
						<div class="food-maker-hover">${food.maker}</div>
					</div>
				</div>
				<div class="food-contents">
					<div class="food-name">
						<h3>${food.foodName}</h3>
					</div>
					<div class="food-material">
						<c:forEach var="mat" items="${food.materialList}" varStatus="i">
							${mat.mat}
							<c:if test="${i.count != food.materialList.size()}">, </c:if>
						</c:forEach>
					</div>
					<c:if test="${sessionScope.member != null}">
					<div class="food-buttons">
						<input type="button" class="intake-btn ingestion-btn" id="${food.foodName}" value="추가"> 
						<input type="button" class="poke-btn likes-btn" id="${food.foodName}" value="찜">
					</div>
					</c:if>
				</div>
			</div>
			
		</c:forEach>
	</c:otherwise>
</c:choose>
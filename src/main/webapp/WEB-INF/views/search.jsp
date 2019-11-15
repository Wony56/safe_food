<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="banner-bottom">
	<form action="searchFood.do" method="post">
		<div class="item">
			<div class="item-label">검색조건</div>
			<div>
				<select name="category">
					<option value="foodName">상품명</option>
					<option value="maker">제조사</option>
					<option value="material">성분</option>
				</select>
			</div>
		</div>
		<div class="item">
			<div class="item-label">검색단어</div>
			<div>
				<input type="text" name="word" id="autocomplete">
			</div>
		</div>
		<div class="item item-submit">
			<input type="hidden" name="location" value="productInfo">
			<input type="submit" value="검색">
		</div>
	</form>
</div>


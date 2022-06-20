<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>단품 구매 예제 - 구매페이지</h1>

<hr>
	<h2>상품 정보</h2>
	<h2>상품 번호 : ${productDto.no}</h2>
	<h2>상품 이름 : ${productDto.name}</h2>
	<h2>상품 유형 : ${productDto.type}</h2>
	<h2>상품 가격 : ${productDto.price}원</h2>
	<h2>상품 제조일 : ${productDto.made}</h2>
	<h2>상품 폐기일 : ${productDto.expire}</h2>
<hr>

<form method="post">
	<input type="hidden" name="no" value="${productDto.no}">
	<input type="number" name="quantity" value="1" min="1" required>
	<input type="submit" value="구매하기" formaction="pay1_purchase">
	<input type="submit" value="장바구니" formaction="pay1_basket">
</form>




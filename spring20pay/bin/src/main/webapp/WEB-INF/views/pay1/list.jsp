<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>단품 구매 예제</h1>

<c:forEach var="productDto" items="${list}">
	<div>
		이름 : ${productDto.name} ,
		분류 : ${productDto.type} ,
		가격 : ${productDto.price}원
		<a href="pay1_purchase?no=${productDto.no}">구매하기</a>
	</div>
</c:forEach>









<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>결제 내역 조회</h1>

<ul>
<c:forEach var="paymentDto" items="${list}">
	<li>
		${paymentDto}
		<a href="more?paymentNo=${paymentDto.paymentNo}">더보기</a>
	</li>
</c:forEach>
</ul>
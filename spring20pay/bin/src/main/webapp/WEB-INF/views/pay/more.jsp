<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- fmt에서는 formatDate, formatNumber를 사용한다 --%>

<h1>결제 내역 상세 페이지</h1>

<h2>대표 정보</h2>

<ul>
	<li>결제 번호 : ${paymentDto.paymentNo}</li>
	<li>거래 번호 : ${paymentDto.paymentTid}</li>
	<li>거래 상품명 : ${paymentDto.paymentName}</li>
	<li>거래 금액 : ${paymentDto.paymentTotal}</li>
	<li>거래 상태 : ${paymentDto.paymentStatus}</li>
	<li>거래 시각 : ${paymentDto.paymentTime}</li>
	<li>
		거래 시각 : 
		<fmt:formatDate 
				value="${paymentDto.paymentTime}" 
				pattern="y년 M월 d일 E a h시 m분 s초"></fmt:formatDate>
	</li>
</ul>

<c:if test="${paymentDto.paymentStatus != '취소'}">
	<a href="cancel_all?paymentNo=${paymentDto.paymentNo}">전체 취소</a>
</c:if>

<h2>상세 내역</h2>

<c:forEach var="paymentDetailDto" items="${paymentDetailList}">
	<div>
		<h3>
			이름 : ${paymentDetailDto.paymentDetailName} , 
			개수 : ${paymentDetailDto.paymentDetailQuantity}개 , 
			금액 : ${paymentDetailDto.paymentDetailPrice}원
			<c:if test="${paymentDetailDto.paymentDetailStatus != '취소'}">
				<a href="cancel?paymentDetailNo=${paymentDetailDto.paymentDetailNo}">취소하기</a>
			</c:if>
		</h3>
	</div>
</c:forEach>

<h2>API 조회 결과</h2>

<ul>
	<li>결제 상태 : ${responseVO.status}</li>
	<li>결제 방법 : ${responseVO.payment_method_type}</li>
</ul>

<h3>결제 진행 단계</h3>
<ul>
	<c:forEach var="paymentActionDetailVO" items="${responseVO.payment_action_details}">
		<li>
			[${paymentActionDetailVO.payment_action_type}]
			금액 : ${paymentActionDetailVO.amount}원
			(${paymentActionDetailVO.approved_at})
			
		</li>
	</c:forEach>
</ul>







package com.kh.spring20.repository;

import java.util.List;

import com.kh.spring20.entity.PaymentDetailDto;
import com.kh.spring20.entity.PaymentDto;
import com.kh.spring20.vo.PaymentListVO;

public interface PaymentDao {
	Object treeList = null;

	int sequence();

	void insertPayment(PaymentDto paymentDto);

	List<PaymentDto> list();

	PaymentDto find(int paymentNo);

	int insertPaymentDetail(PaymentDetailDto paymentDetailDto);

	List<PaymentDetailDto> listDetail(int paymentNo);

	boolean cancelDetail(PaymentDetailDto paymentDetailDto);

	PaymentDetailDto findDetail(int paymentDetailNo);

	int calculateCancelAmountByJava(int paymentNo);

	int calculateCancelAmountByOracle(int paymentNo);

	void cancelAll(int paymentNo);

	List<PaymentListVO> treeList();
}

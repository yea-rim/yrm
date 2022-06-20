package com.kh.spring20.vo;

import java.util.List;

import com.kh.spring20.entity.PaymentDetailDto;
import com.kh.spring20.entity.PaymentDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentListVO {

	// 1개의 대표결제 정보와 여러 개의 결제상세 정보가 들어야 한다
	// 1개의 대표결제정보 = PaymentDto
	// 여러 개의 결제상세정보 = List<PaymentDetailDto>

	private PaymentDto paymentDto;
	private List<PaymentDetailDto> paymentDetailList;

}

package com.kh.spring20.service;

import java.util.List;

import com.kh.spring20.vo.KakaoPayApproveResponseVO;
import com.kh.spring20.vo.PurchaseVO;

public interface PaymentService {

	void insert(int paymentNo, KakaoPayApproveResponseVO responseVO, List<PurchaseVO> purchaseList);

}

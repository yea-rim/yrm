package com.kh.spring20.service;

import java.net.URISyntaxException;

import com.kh.spring20.vo.KakaoPayApproveRequestVO;
import com.kh.spring20.vo.KakaoPayApproveResponseVO;
import com.kh.spring20.vo.KakaoPayCancelRequestVO;
import com.kh.spring20.vo.KakaoPayCancelResponseVO;
import com.kh.spring20.vo.KakaoPayOrderRequestVO;
import com.kh.spring20.vo.KakaoPayOrderResponseVO;
import com.kh.spring20.vo.KakaoPayReadyRequestVO;
import com.kh.spring20.vo.KakaoPayReadyResponseVO;

public interface KakaoPayService {
	KakaoPayReadyResponseVO ready(KakaoPayReadyRequestVO requestVO) throws URISyntaxException;
	KakaoPayApproveResponseVO approve(KakaoPayApproveRequestVO requestVO) throws URISyntaxException;
	KakaoPayOrderResponseVO order(KakaoPayOrderRequestVO requestVO) throws URISyntaxException;
	KakaoPayCancelResponseVO cancel(KakaoPayCancelRequestVO requestVO) throws URISyntaxException;
}

package com.kh.spring20;

import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring20.service.KakaoPayService;
import com.kh.spring20.vo.KakaoPayOrderRequestVO;
import com.kh.spring20.vo.KakaoPayOrderResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class KakaoPayOrderTest {

	@Autowired
	private KakaoPayService kakaoPayService;
	
	@Test
	public void test() throws URISyntaxException {
		KakaoPayOrderResponseVO responseVO = 
					kakaoPayService.order(KakaoPayOrderRequestVO.builder()
																			.tid("T2a700b8652005082b1d")
																		.build());
		log.debug("responseVO = {}", responseVO);
	}
	
}







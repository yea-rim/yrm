package com.kh.spring20;

import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring20.service.KakaoPayService;
import com.kh.spring20.vo.KakaoPayApproveRequestVO;
import com.kh.spring20.vo.KakaoPayApproveResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class KakaoPayApproveTest {
	
	@Autowired
	private KakaoPayService kakaoPayService;
	
	@Test
	public void test() throws URISyntaxException {
		KakaoPayApproveResponseVO responseVO = 
					kakaoPayService.approve(
							KakaoPayApproveRequestVO.builder()
									.partner_order_id("8a2404f9-bcbb-4e56-8732-4adf3ff37d75")
									.partner_user_id("testuser1")
									.tid("T2a6ccdf65200508278c")
									.pg_token("0f5fe257106790120a41")
								.build()
					);
		log.debug("responseVO = {}", responseVO);
	}
	
}

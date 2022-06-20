package com.kh.spring20;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring20.vo.KakaoPayReadyResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test02 {

	@Test
	public void test() throws URISyntaxException {
		//RestTemplate을 이용해서 서버끼리의 통신 요청을 수행한다
		RestTemplate template = new RestTemplate();
		
		//정보에는 Header와 Body가 존재한다(POST방식)
		HttpHeaders headers = new HttpHeaders();
		//headers.add("이름", "값");
		headers.add("Authorization", "KakaoAK abef795eb57a2403cd87586d7facce50");
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		//body.add("이름", "값");
		body.add("cid", "TC0ONETIME");
		String partner_order_id = UUID.randomUUID().toString();
		body.add("partner_order_id", partner_order_id);//임시로 랜덤 시리얼 번호 사용
		String partner_user_id = "testuser1";
		body.add("partner_user_id", partner_user_id);
		body.add("item_name", "강남 아파트 외 3개");
		body.add("quantity", "1");
		body.add("total_amount", "99900");
		body.add("tax_free_amount", "0");//무조건 0원
		
		//반드시 등록된 주소로 시작해야 함(카카오 개발자센터 -> 플랫폼 확인)
		body.add("approval_url", "http://localhost:8080/spring20/pay/approve");
		body.add("cancel_url", "http://localhost:8080/spring20/pay/cancel");
		body.add("fail_url", "http://localhost:8080/spring20/pay/fail");
		
		//만들어진 header와 body를 하나로 만든다
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		//만들어진 요청객체를 전송하여 원하는 결과를 얻어낸다
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");
		
		//Map을 이용하면 클래스 없이도 데이터를 받아서 확인할 수 있지만 최종 형태로는 권장하지 않음
		//Map<String, Object> resp = template.postForObject(uri, entity, Map.class);
		//log.debug("resp = {}", resp);
		
		//클래스를 이용해서 요청에 대한 응답을 분석할 수 있다
		KakaoPayReadyResponseVO vo = 
				template.postForObject(uri, entity, KakaoPayReadyResponseVO.class);
		log.debug("vo = {}", vo);
		log.debug(vo.getNext_redirect_pc_url());
		
		log.warn("tid = {}", vo.getTid());
		log.warn("parnter_order_id = {}", partner_order_id);
		log.warn("partner_user_id = {}", partner_user_id);
	}
	
}






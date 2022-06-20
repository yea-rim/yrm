package com.kh.spring20;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring20.entity.PaymentDetailDto;
import com.kh.spring20.vo.PaymentListVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@WebAppConfiguration
public class Test05 {

	@Autowired
	private SqlSession sqlSession;

	// 대표정보 밑에 상세정보를 계층적으로 넣어준다
	
	@Test
	public void test() {
		List<PaymentListVO> list = sqlSession.selectList("treeSearch");
		for (PaymentListVO vo : list) {
			log.debug("payment = {}", vo.getPaymentDto());
			for (PaymentDetailDto dto : vo.getPaymentDetailList()) {
				log.debug("-> paymentDetail = {}", dto);
			}
		}
	}
}

package com.multi.orderdetail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.OrderdetailDTO;
import com.multi.service.OrderdetailService;

@SpringBootTest
class GetAllInfo {

	@Autowired
	OrderdetailService service;
	
	@Test
	void contextLoads() {
		OrderdetailDTO oinfo = null;
		try {
			oinfo = service.getallinfo(1000); // orderlistid로 해당 예매내역 조회
			System.out.println(oinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

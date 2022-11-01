package com.multi.orderdetail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.OrderdetailDTO;
import com.multi.service.OrderdetailService;

@SpringBootTest
class GetAllOrderdetail {

	@Autowired
	OrderdetailService service;
	
	@Test
	void contextLoads() {
		List<OrderdetailDTO> list = null;
		try {
			list = service.getallorderdetail("id02");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(OrderdetailDTO o:list) {
			System.out.println(o);
		}
	}

}

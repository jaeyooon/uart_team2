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
	void contextloads() {
		List<OrderdetailDTO> list = null;
		
		try {
			list = service.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(OrderdetailDTO o:list) {
			System.out.println(o);
		}
	}
}

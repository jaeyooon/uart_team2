package com.multi.orderlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.OrderlistDTO;
import com.multi.service.OrderlistService;

@SpringBootTest
class GetOrderlist {

	@Autowired
	OrderlistService service;
	
	@Test
	void contextLoads() {
		OrderlistDTO order = null;
		try {
			order = service.get(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(order);
	}

}

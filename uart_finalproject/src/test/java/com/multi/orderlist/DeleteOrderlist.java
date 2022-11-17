package com.multi.orderlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.OrderlistDTO;
import com.multi.service.OrderlistService;

@SpringBootTest
class DeleteOrderlist {

	@Autowired
	OrderlistService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(1001);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

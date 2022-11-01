package com.multi.orderdetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.OrderdetailService;

@SpringBootTest
class DeleteOrderdetail {

	@Autowired
	OrderdetailService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(42);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package com.multi.kitem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.ItemService2;

@SpringBootTest
class DeleteItem2 {
	@Autowired
	ItemService2 service;

	@Test
	void contextLoads() {
		try {
			service.remove(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("deleted");
	}
	

}

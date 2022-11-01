package com.multi.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ItemDTO;
import com.multi.service.ItemService;

@SpringBootTest
class GetItem {
	
	@Autowired
	ItemService service;

	@Test
	void contextLoads() {
		ItemDTO item = null;
		try {
			item=service.get(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(item);
	}

}
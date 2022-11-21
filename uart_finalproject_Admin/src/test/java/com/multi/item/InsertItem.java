package com.multi.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ItemDTO;
import com.multi.service.ItemService;

@SpringBootTest
class InsertItem {
	
	@Autowired
	ItemService service;

	@Test
	void contextLoads() {
		ItemDTO item = new ItemDTO();
		try {
			service.register(item);
			System.out.println("Insert:");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package com.multi.item;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ItemDTO;
import com.multi.service.ItemService;

@SpringBootTest
class UpdateItem {
	
	@Autowired
	ItemService service;

	@Test
	void contextLoads() {
		ItemDTO item = new ItemDTO(124,2,null,null,null,null,null,null,null,null,0, new Date("Sun, 13 NOV 2022 11:05:23 +900"), new Date("Fri, 18 NOV 2022 11:05:23 +900"), null, null, null, null, null, null, null, null);
		try {
			service.modify(item);
			System.out.println("Update:");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

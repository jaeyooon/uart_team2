package com.multi.item;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ItemDTO;
import com.multi.service.ItemService;

@SpringBootTest
class DeleteItem {
	
	@Autowired
	ItemService service;

	@Test
	void contextLoads() {
	List<ItemDTO> item=null;
		try {
			service.remove(124);
			item=service.get();
			System.out.println(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

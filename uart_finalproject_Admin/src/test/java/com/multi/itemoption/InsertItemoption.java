package com.multi.itemoption;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ItemoptionDTO;
import com.multi.service.ItemoptionService;

@SpringBootTest
class InsertItemoption {
	
	@Autowired
	ItemoptionService service;

	@Test
	void contextLoads() {
		ItemoptionDTO option = new ItemoptionDTO();
		try {
			service.register(option);
			System.out.println("Insert:");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

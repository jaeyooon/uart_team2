package com.multi.itemoption;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ItemDTO;
import com.multi.dto.ItemoptionDTO;
import com.multi.service.ItemoptionService;

@SpringBootTest
class UpdateItemoption {
	
	@Autowired
	ItemoptionService service;

	@Test
	void contextLoads() {
		ItemoptionDTO option = new ItemoptionDTO(null, 123, null, 10000, null, 5000, null, 3000);
		try {
			service.modify(option);
			System.out.println("Update:");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

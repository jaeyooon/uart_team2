package com.multi.itemoption;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ItemoptionDTO;
import com.multi.service.ItemoptionService;

@SpringBootTest
class GetItemOption {

	@Autowired
	ItemoptionService service;

	@Test
	void contextLoads() {
		List<ItemoptionDTO> list = null;
		try {
			list = service.getitem(122);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(ItemoptionDTO t:list) {
			System.out.println(t);
		}
	}

}
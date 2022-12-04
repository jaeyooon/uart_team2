package com.multi.item;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CateDTO;
import com.multi.dto.ItemDTO;
import com.multi.mapper.ItemMapper;
import com.multi.service.ItemService;

@SpringBootTest
class Selectpage {
	
	@Autowired
	ItemMapper mapper;

	@Test
	void contextLoads() {
		List<ItemDTO> list =null;
		try {
			list = mapper.selectpage(12);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(ItemDTO p:list) {
			System.out.println(p);
		}
		
	}

}
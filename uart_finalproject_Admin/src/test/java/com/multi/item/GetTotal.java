package com.multi.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ItemDTO;
import com.multi.mapper.ItemMapper;
import com.multi.service.ItemService;

@SpringBootTest
class GetTotal {
	
	@Autowired
	ItemMapper mapper;

	@Test
	void contextLoads() {
		try {
			System.out.println(mapper.getTotal());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
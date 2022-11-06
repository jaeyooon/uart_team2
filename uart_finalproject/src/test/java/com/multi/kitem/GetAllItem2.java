package com.multi.kitem;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ItemDTO2;
import com.multi.service.ItemService2;


@SpringBootTest
class GetAllItem2 {

	@Autowired
	ItemService2 service;
	
	@Test
	void contextLoads() {
		List<ItemDTO2> list = null;
		try {
			list = service.itemall2(101);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(ItemDTO2 c:list) {
			System.out.println(c);
		}
		
	}

}
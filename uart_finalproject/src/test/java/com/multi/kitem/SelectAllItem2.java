package com.multi.kitem;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ItemDTO2;
import com.multi.service.ItemService2;

@SpringBootTest
class SelectAllItem2 {
	@Autowired
	ItemService2 service;

	@Test
	void contextLoads() {
		List<ItemDTO2> list = null;
		try {
			list = service.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(ItemDTO2 i:list) {
			System.out.println(i);
		}
	}

}

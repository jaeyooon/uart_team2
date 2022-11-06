package com.multi.kitem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ItemDTO2;
import com.multi.service.ItemService2;

@SpringBootTest
class SelectItem2 {
	@Autowired
	ItemService2 service;

	@Test
	void contextLoads() {
		ItemDTO2 kitem = null;
		try {
			kitem = service.get(100);
			System.out.println(kitem);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

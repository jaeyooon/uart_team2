package com.multi.kitem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.KItemDTO;
import com.multi.service.KItemService;

@SpringBootTest
class SelectKItem {
	@Autowired
	KItemService service;

	@Test
	void contextLoads() {
		KItemDTO kitem = null;
		try {
			kitem = service.get(100);
			System.out.println(kitem);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

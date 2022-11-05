package com.multi.kitem;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.KItemDTO;
import com.multi.service.KItemService;

@SpringBootTest
class SelectAllKItem {
	@Autowired
	KItemService service;

	@Test
	void contextLoads() {
		List<KItemDTO> list = null;
		try {
			list = service.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(KItemDTO i:list) {
			System.out.println(i);
		}
	}

}

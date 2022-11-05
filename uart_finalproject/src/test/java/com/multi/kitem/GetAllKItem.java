package com.multi.kitem;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.KItemDTO;
import com.multi.service.KItemService;


@SpringBootTest
class GetAllKItem {

	@Autowired
	KItemService service;
	
	@Test
	void contextLoads() {
		List<KItemDTO> list = null;
		try {
			list = service.kitemall(100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(KItemDTO c:list) {
			System.out.println(c);
		}
		
	}

}
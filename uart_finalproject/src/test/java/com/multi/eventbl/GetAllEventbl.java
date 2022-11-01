package com.multi.eventbl;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.EventblDTO;
import com.multi.service.EventblService;

@SpringBootTest
class GetAllEventbl {
	
	@Autowired
	EventblService service;
	
	@Test
	void contextloads() {
		List<EventblDTO> list = null;
		
		try {
			list = service.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(EventblDTO c:list) {
			System.out.println(c);
		}
	}
}
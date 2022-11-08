package com.multi.eventbl;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.EventblDTO;
import com.multi.service.EventblService;

@SpringBootTest
class InsertEventbl {

	@Autowired
	EventblService service;
	
	@Test
	void contextLoads() {
		EventblDTO event = new EventblDTO(null, "id11", null, null, null, null, null, null, null);
		try {
			service.register(event);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

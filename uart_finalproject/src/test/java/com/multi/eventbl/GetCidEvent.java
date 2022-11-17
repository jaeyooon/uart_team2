package com.multi.eventbl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CustomerDTO;
import com.multi.dto.EventblDTO;
import com.multi.service.CustomerService;
import com.multi.service.EventblService;

@SpringBootTest
class GetCidEvent {

	@Autowired
	EventblService service;

	@Test
	void contextLoads() {
		EventblDTO event = null;
		try {
			event = service.getcidevent("id10");
			System.out.println(event);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
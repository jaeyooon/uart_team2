package com.multi.eventbl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CustomerDTO;
import com.multi.dto.EventblDTO;
import com.multi.service.CustomerService;
import com.multi.service.EventblService;

@SpringBootTest
class DeleteCoupon {

	@Autowired
	EventblService service;

	@Test
	void contextLoads() {
		EventblDTO event = new EventblDTO(null, "id10", null, null, null, null, null, null, 0, null);
		try {
			service.deletecoupon(event);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
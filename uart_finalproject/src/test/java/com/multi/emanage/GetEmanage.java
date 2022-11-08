package com.multi.emanage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CustomerDTO;
import com.multi.dto.EmanageDTO;
import com.multi.dto.EventblDTO;
import com.multi.service.CustomerService;
import com.multi.service.EmanageService;
import com.multi.service.EventblService;

@SpringBootTest
class GetEmanage {

	@Autowired
	EmanageService service;

	@Test
	void contextLoads() {
		EmanageDTO emanage;
		try {
			emanage = service.get("12349876");
			System.out.println(emanage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
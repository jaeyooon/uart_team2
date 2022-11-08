package com.multi.emanage;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.EmanageDTO;
import com.multi.service.EmanageService;

@SpringBootTest
class InsertEmanage {

	@Autowired
	EmanageService service;
	
	@Test
	void contextLoads() {
		EmanageDTO emanage = new EmanageDTO("23458765", null);
		try {
			service.register(emanage);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

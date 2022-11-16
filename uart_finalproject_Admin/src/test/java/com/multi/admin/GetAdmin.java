package com.multi.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.AdminDTO;
import com.multi.service.AdminService;

@SpringBootTest
class GetAdmin {
	@Autowired
	AdminService service;
	
	@Test
	void contextloads() {
		AdminDTO admin = null;
		
		try {
			admin = service.get("admin01");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(admin);
	}
}

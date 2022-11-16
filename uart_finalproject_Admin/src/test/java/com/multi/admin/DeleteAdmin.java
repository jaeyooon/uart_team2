package com.multi.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.multi.service.AdminService;

@SpringBootTest
class DeleteAdmin {
	@Autowired
	AdminService service;
	
	@Test
	void contextloads() {		
		try {
			service.remove("admin09");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

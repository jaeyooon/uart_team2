package com.multi.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.AdminDTO;
import com.multi.service.AdminService;

@SpringBootTest
class UpdateAdmin {
	
	@Autowired
	AdminService service;
	
	@Test
	void contextloads() {
		AdminDTO admin = new AdminDTO("admin09", "pwd09", "Anne", "wogud113@gmail.com", "010-4322-2121", "B");
		
		try {
			service.modify(admin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

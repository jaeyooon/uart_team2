package com.multi.admin;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.AdminDTO;
import com.multi.service.AdminService;

@SpringBootTest
class InsertAdmin {
	@Autowired
	AdminService service;

	@Test
	void contextLoads() {
		AdminDTO adm = new AdminDTO("admin09", "pwd09", "Jean Antoine" , "jeanf121@uart.com", "010-7432-2019" ,"I");

		try {
			service.register(adm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("inserted");

	}
}
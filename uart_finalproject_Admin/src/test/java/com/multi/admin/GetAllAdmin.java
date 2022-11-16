package com.multi.admin;



import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.AdminDTO;
import com.multi.service.AdminService;

@SpringBootTest
class GetAllAdmin{
	@Autowired
	AdminService service;

	@Test
	void contextLoads() {
		List<AdminDTO> list = null;

		try {
			list = service.get();
		} catch (Exception e) {
			e.printStackTrace();
		}

		for(AdminDTO c:list) {
			System.out.println(c);
		}

	}
}

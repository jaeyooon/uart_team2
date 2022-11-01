package com.multi.wish;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.WishDTO;
import com.multi.service.WishService;

@SpringBootTest
class UpdateWish {

	@Autowired
	WishService service;
	
	@Test
	void contextLoads() {
		WishDTO wish = new WishDTO(20, "id01", 107, null, null);
		try {
			service.modify(wish);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("updated");
	}
}



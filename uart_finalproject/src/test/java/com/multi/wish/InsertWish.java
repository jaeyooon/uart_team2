package com.multi.wish;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.WishDTO;
import com.multi.service.WishService;

@SpringBootTest
class InsertWish {

	@Autowired
	WishService service;
	
	@Test
	void contextLoads() {
		WishDTO wish = new WishDTO(null, "id10", 107, null, null);
		try {
			service.register(wish);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("inserted");
	}
}

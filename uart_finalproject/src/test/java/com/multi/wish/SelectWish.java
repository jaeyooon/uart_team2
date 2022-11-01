package com.multi.wish;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.WishDTO;
import com.multi.service.WishService;

@SpringBootTest
class SelectWish {

	@Autowired
	WishService service;
	
	@Test
	void contextLoads() {
		WishDTO wish = null;
		try {
			wish = service.get(20);
			System.out.println(wish);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
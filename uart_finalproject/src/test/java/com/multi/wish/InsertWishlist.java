package com.multi.wish;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.WishlistDTO;
import com.multi.service.WishlistService;

@SpringBootTest
class InsertWishlist {

	@Autowired
	WishlistService service;
	
	@Test
	void contextLoads() {
		WishlistDTO wish = new WishlistDTO(null, "id10", 116, null, null, null, null, null);
		try {
			service.register(wish);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("inserted");
	}
}

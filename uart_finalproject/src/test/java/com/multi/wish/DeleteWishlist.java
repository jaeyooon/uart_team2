package com.multi.wish;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.WishlistService;

@SpringBootTest
class DeleteWishlist {

	@Autowired
	WishlistService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(35);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("deleted");
	}
}

package com.multi.wish;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.WishlistDTO;
import com.multi.service.WishlistService;


@SpringBootTest
class GetAllWishlist {

	@Autowired
	WishlistService service;
	
	@Test
	void contextLoads() {
		List<WishlistDTO> list = null;
		try {
			list = service.wishlistall("id01");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(WishlistDTO c:list) {
			System.out.println(c);
		}
		
	}

}
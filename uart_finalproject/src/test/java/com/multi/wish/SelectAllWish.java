package com.multi.wish;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.WishDTO;
import com.multi.service.WishService;


@SpringBootTest
class SelectAllWish {

	@Autowired
	WishService service;
	
	@Test
	void contextLoads() {
		List<WishDTO> list = null;
		try {
			list = service.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(WishDTO c:list) {
			System.out.println(c);
		}
		
	}

}
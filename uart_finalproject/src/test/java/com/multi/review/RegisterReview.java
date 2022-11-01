package com.multi.review;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ReviewDTO;
import com.multi.service.ReviewService;

@SpringBootTest
class RegisterReview {
	
	@Autowired
	ReviewService service;
	
	@Test
	void contextloads() {
		ReviewDTO review = new ReviewDTO(100, 1 ,"jh","너무나 유익한 전시에요",5.0, null);
		try {
			service.register(review);
			System.out.println(review);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

package com.multi.review;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ReviewDTO;
import com.multi.service.ReviewService;

@SpringBootTest
class GetItemReview2 {
	@Autowired
	ReviewService service;
	
	@Test
	void contextloads() {
		List<ReviewDTO> list = null;
		
		try {
			list = service.getitemreview(100);
			for(ReviewDTO r:list)
				System.out.println(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

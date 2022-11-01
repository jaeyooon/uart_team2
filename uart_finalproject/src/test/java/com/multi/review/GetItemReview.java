package com.multi.review;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ReviewDTO;
import com.multi.service.ReviewService;

@SpringBootTest
class GetItemReview {
	@Autowired
	ReviewService service;
	
	@Test
	void contextloads() {
		List<ReviewDTO> list = null;
		
		try {
			list = service.get_itemreview(3);
			for(ReviewDTO i:list)
				System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(ReviewDTO c:list) {
			System.out.println(c);
		}
	}
	
}

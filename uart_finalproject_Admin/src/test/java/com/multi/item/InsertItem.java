package com.multi.item;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ItemDTO;
import com.multi.service.ItemService;

@SpringBootTest
class InsertItem {
	
	@Autowired
	ItemService service;

	@Test
	void contextLoads() {
		ItemDTO item = new ItemDTO(null, 1, "어느날", "a.jpg", "전당", "경기도", 3.564, 2.5234, "전체관람가", "온라인수령", 100, new Date("Sun, 13 NOV 2022 11:05:23 +900"), new Date("Fri, 18 NOV 2022 11:05:23 +900"),null,null,null,null, "성인", 1000, "청소년", 500, "어린이", 200, "미디어전시");
		try {
			service.register(item);
			System.out.println("Insert:");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

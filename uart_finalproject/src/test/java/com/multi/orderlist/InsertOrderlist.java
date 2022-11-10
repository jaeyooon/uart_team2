package com.multi.orderlist;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.OrderdetailDTO;
import com.multi.dto.OrderlistDTO;
import com.multi.service.OrderdetailService;
import com.multi.service.OrderlistService;

@SpringBootTest
class InsertOrderlist {

	@Autowired
	OrderlistService service;
	
	@Autowired
	OrderdetailService service2;
	
	@Test
	void contextLoads() { 
		OrderlistDTO order = new OrderlistDTO(0, 121, "id10", new Date("Sun, 25 Dec 2022 00:00:00 +0900"), 1, 17000, "신용카드", "010-1344-7813", new Date("Wed, 28 Dec 2022 00:00:00 +0900"), "포토아크, 너의 이름은", "조우진");
		try {
			service.register(order);
			int r = order.getOrderlistid();
			System.out.println("Register OK "+r); 
			OrderdetailDTO odetail = new OrderdetailDTO(0, r, 121, "경상남도문화예술회관 제2전시실", new Date("Tue, 18 Oct 2022 00:00:00 +0900"), new Date("Sun, 25 Dec 2022 00:00:00 +0900"), "img22.jpg" , "포토아크, 너의 이름은", 1, new Date("Mon, 26 Dec 2022 00:00:00 +0900"), new Date("Wed, 28 Dec 2022 00:00:00 +0900"), "id10");
			service2.register(odetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("OK");
	}

}

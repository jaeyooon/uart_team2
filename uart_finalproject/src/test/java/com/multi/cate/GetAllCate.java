package com.multi.cate;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CateDTO;
import com.multi.service.CateService;

@SpringBootTest
class GetAllCate {
	
	@Autowired
	CateService service;

	@Test
	void contextLoads() {
		List<CateDTO> list =null;
		try {
			list=service.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(CateDTO c:list) {
			System.out.println(c);
		}
		
	}

}
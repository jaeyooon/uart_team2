package com.multi.ajax;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.AdminDTO;
import com.multi.dto.CustomerDTO;
import com.multi.mapper.AJAXMapper;
import com.multi.service.AdminService;

@SpringBootTest
class CustCnt {

	@Autowired
	AJAXMapper mapper;
	
	@Test
	void contextLoads() {
		int cnt = 0;
		try {
			cnt = mapper.getCustCnt();
			System.out.println(cnt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}





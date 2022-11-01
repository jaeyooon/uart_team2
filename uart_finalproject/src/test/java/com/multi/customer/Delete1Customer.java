package com.multi.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CustomerDTO;
import com.multi.service.CustomerService;

@SpringBootTest
class Delete1Customer {

	@Autowired
	CustomerService service;

	@Test
	void contextLoads() {
		CustomerDTO cust = new CustomerDTO("id01", "pwd01", "박민준", "001010",null,"mjpark@naver.com","010-1234-5678",null,0);
		try {
			service.delete1(cust);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
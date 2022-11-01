package com.multi.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CustomerDTO;
import com.multi.service.CustomerService;

@SpringBootTest
class InsertCustomer {

	@Autowired
	CustomerService service;

	@Test
	void contextLoads() {
		CustomerDTO cust = new CustomerDTO("id11", "pwd11","송연아", "980403", "여", "yasong@naver.com", "010-6639-0097", null, 0);
		try {
			service.register(cust);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
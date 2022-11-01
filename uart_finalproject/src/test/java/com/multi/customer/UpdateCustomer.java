package com.multi.customer;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CustomerDTO;
import com.multi.service.CustomerService;

@SpringBootTest
class UpdateCustomer {

	@Autowired
	CustomerService service;

	@Test
	void contextLoads() {
		CustomerDTO cust = new CustomerDTO("id03", "pwd3", "강예솔", "040425", "남", "yjkang@naver.com","010-5436-3354",new Date("Thu, 23 JAN 2019 11:05:23 +900"), 1);
		try {
			service.modify(cust);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
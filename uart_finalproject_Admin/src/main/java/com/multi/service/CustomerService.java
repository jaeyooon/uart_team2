package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.CustomerDTO;
import com.multi.frame.MyService;
import com.multi.mapper.CustomerMapper;

@Service
public class CustomerService implements MyService<String, CustomerDTO>{

	@Autowired
	CustomerMapper mapper;
	
	@Override
	public void register(CustomerDTO v) throws Exception {
		mapper.insert(v);		
	}
	
	@Override
	public void remove(String k) throws Exception {
		mapper.delete(k);
		
	}

	
	@Override
	public void modify(CustomerDTO v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public CustomerDTO get(String k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<CustomerDTO> get() throws Exception {
		return mapper.selectall();
	}

	public void delete1(CustomerDTO cust) throws Exception {
		mapper.delete1(cust);
		
	}

}

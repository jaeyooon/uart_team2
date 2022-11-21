package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.multi.dto.OrderlistDTO;
import com.multi.frame.MyService;
import com.multi.mapper.OrderlistMapper;

@Service
public class OrderlistService implements MyService<Integer, OrderlistDTO> {
	
	@Autowired
	OrderlistMapper mapper;
	
	@Override
	public void register(OrderlistDTO v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(OrderlistDTO v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public OrderlistDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<OrderlistDTO> get() throws Exception {
		return mapper.selectall();
	}

}

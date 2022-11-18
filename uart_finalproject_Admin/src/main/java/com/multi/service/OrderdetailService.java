package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.OrderdetailDTO;
import com.multi.frame.MyService;
import com.multi.mapper.OrderdetailMapper;

@Service
public class OrderdetailService implements MyService<Integer, OrderdetailDTO> {
	
	@Autowired
	OrderdetailMapper mapper;
	
	@Override
	public void register(OrderdetailDTO v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(OrderdetailDTO v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public OrderdetailDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<OrderdetailDTO> get() throws Exception {
		return mapper.selectall();
	}

}

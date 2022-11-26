package com.multi.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.AdminDTO;
import com.multi.frame.MyService;
import com.multi.mapper.AdminMapper;

@Service
public class AdminService implements MyService<String, AdminDTO>{
	
	@Autowired
	AdminMapper mapper;

	@Override
	public void register(AdminDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(AdminDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public AdminDTO get(String k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<AdminDTO> get() throws Exception {
		return mapper.selectall();
	}

	public AdminDTO login(AdminDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void keepLogin(Object userId, String id, Date sessionLimit) {
		// TODO Auto-generated method stub
		
	}
}

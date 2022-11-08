package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.EmanageDTO;
import com.multi.frame.MyService;
import com.multi.mapper.EmanageMapper;

@Service
public class EmanageService implements MyService<String, EmanageDTO> {
	
	@Autowired
	EmanageMapper mapper;

	@Override
	public void register(EmanageDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(EmanageDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public EmanageDTO get(String k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<EmanageDTO> get() throws Exception {
		return null;
	}

}
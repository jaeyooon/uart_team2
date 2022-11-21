package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.ItemoptionDTO;
import com.multi.frame.MyService;
import com.multi.mapper.ItemoptionMapper;

@Service
public class ItemoptionService implements MyService<Integer, ItemoptionDTO>{

	@Autowired
	ItemoptionMapper mapper;

	@Override
	public void register(ItemoptionDTO v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(ItemoptionDTO v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public ItemoptionDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	
	@Override
	public List<ItemoptionDTO> get() throws Exception {
		return null;
	}
	
	public List<ItemoptionDTO> getitem(Integer item) throws Exception{
		return mapper.getitem(item);
	}
}
package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.EventblDTO;
import com.multi.frame.MyMapper;

@Mapper
@Repository
public interface EventblMapper extends MyMapper<Integer, EventblDTO>{
	public List<EventblDTO> select_itemreview(Integer itemid) throws Exception;
	public List<EventblDTO> getall() throws Exception;
}
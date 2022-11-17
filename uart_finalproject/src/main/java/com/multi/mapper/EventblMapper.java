package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.EventblDTO;
import com.multi.frame.MyMapper;

@Mapper
@Repository
public interface EventblMapper extends MyMapper<Integer, EventblDTO>{
	public EventblDTO getcustevent(String k) throws Exception;
	public EventblDTO getcidevent(String k) throws Exception;
	public void deletecoupon(EventblDTO event) throws Exception;
}
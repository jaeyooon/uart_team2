package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.EventblDTO;
import com.multi.frame.MyMapper;

@Mapper
@Repository
public interface EventblMapper extends MyMapper<Integer, EventblDTO>{

}
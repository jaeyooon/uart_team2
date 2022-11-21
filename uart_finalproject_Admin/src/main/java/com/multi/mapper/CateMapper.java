package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.CateDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface CateMapper extends MyMapper<Integer, CateDTO>{

}
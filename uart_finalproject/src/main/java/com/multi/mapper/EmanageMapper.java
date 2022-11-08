package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.EmanageDTO;
import com.multi.frame.MyMapper;

@Mapper
@Repository
public interface EmanageMapper extends MyMapper<String, EmanageDTO>{

}
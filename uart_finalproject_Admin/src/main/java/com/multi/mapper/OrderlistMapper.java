package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.OrderlistDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface OrderlistMapper extends MyMapper<Integer, OrderlistDTO>{	
}
 
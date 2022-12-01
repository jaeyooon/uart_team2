package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.OrderlistDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface OrderlistMapper extends MyMapper<Integer, OrderlistDTO>{
	public List<OrderlistDTO> searchitem(String txt) throws Exception;
	public List<OrderlistDTO> latest_r() throws Exception;
	public List<OrderlistDTO> early_r() throws Exception;
	public List<OrderlistDTO> latest2_r(String txt) throws Exception;
	public List<OrderlistDTO> early2_r(String txt) throws Exception;
}
 
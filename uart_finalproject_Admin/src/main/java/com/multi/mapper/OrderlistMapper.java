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
	public List<OrderlistDTO> latest_r(Integer offset) throws Exception;
	public List<OrderlistDTO> early_r(Integer offset) throws Exception;
	public List<OrderlistDTO> latest2_r(String txt) throws Exception;
	public List<OrderlistDTO> early2_r(String txt) throws Exception;
	public int getTotal();   // 총 예매내역 수
	public List<OrderlistDTO> selectpage(Integer offset) throws Exception;
}
 
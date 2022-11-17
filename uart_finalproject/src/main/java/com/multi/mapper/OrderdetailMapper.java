package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.OrderdetailDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface OrderdetailMapper extends MyMapper<Integer, OrderdetailDTO>{	
	public List<OrderdetailDTO> getallorderdetail(String cust_custid) throws Exception;
	public OrderdetailDTO getallinfo(Integer orderlistid) throws Exception;
}

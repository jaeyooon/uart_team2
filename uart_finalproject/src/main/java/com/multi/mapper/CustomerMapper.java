package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import com.multi.dto.CustomerDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface CustomerMapper extends MyMapper<String, CustomerDTO>{	// 인터페이스를 상속받아서 인터페이스를 만듬
	public void delete1(CustomerDTO cust) throws Exception;

}
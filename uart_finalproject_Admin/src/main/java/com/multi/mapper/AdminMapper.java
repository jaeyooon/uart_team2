package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.AdminDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface AdminMapper extends MyMapper<String, AdminDTO>{	// 인터페이스를 상속받아서 인터페이스를 만듬
	
}
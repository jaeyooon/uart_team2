package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.ItemDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface AJAXMapper extends MyMapper<Integer, ItemDTO>{
	public List<ItemDTO> getname() throws Exception;

}

package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.ItemDTO2;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface ItemMapper2 extends MyMapper<Integer, ItemDTO2>{
	public List<ItemDTO2> itemall2(Integer itemid) throws Exception;
}
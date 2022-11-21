package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import com.multi.dto.ItemoptionDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface ItemoptionMapper extends MyMapper<Integer, ItemoptionDTO>{	// 인터페이스를 상속받아서 인터페이스를 만듬
	public List<ItemoptionDTO> getitem(Integer item) throws Exception;	//itemid에 해당하는 목록 조회

}
package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.KItemDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface KItemMapper extends MyMapper<Integer, KItemDTO>{
	public List<KItemDTO> kitemall(Integer itemid) throws Exception;
}
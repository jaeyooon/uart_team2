package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.ReviewDTO;
import com.multi.frame.MyMapper;

@Mapper
@Repository
public interface ReviewMapper extends MyMapper<Integer, ReviewDTO>{
	public List<ReviewDTO> select_itemreview(Integer itemid) throws Exception;
	public List<ReviewDTO> getall() throws Exception;
}
package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.ItemDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface ItemMapper extends MyMapper<Integer, ItemDTO>{
	public List<ItemDTO> gethighgrade() throws Exception;
	public int getTotal();  // 상품목록 총 갯수
	public List<ItemDTO> selectpage(Integer offset) throws Exception;
}

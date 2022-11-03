package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.ItemDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface ItemMapper extends MyMapper<Integer, ItemDTO>{
	public List<ItemDTO> select_cate(Integer k) throws Exception;
	public List<ItemDTO> searchitem(String txt) throws Exception;
	public List<ItemDTO> gethighgrade() throws Exception;
	public <V> V select2(Integer k) throws Exception;
	public <V> V select3(Integer k) throws Exception;

}
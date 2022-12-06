package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.WishlistDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface WishlistMapper extends MyMapper<Integer, WishlistDTO>{
	public List<WishlistDTO> wishlistall(String custid) throws Exception;
	/* 카트 추가 */
	public int addWish(WishlistDTO wish) throws Exception;
	/* 카트 확인 */
	public WishlistDTO checkWish(WishlistDTO wish);	
}
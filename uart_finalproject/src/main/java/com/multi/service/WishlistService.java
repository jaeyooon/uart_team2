package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.WishlistDTO;
import com.multi.frame.MyService;
import com.multi.mapper.WishlistMapper;

@Service
public class WishlistService implements MyService<Integer, WishlistDTO>{

	@Autowired
	WishlistMapper mapper;
	
	@Override
	public void register(WishlistDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(WishlistDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public WishlistDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<WishlistDTO> get() throws Exception {
		return mapper.selectall();
	}
	
	public List<WishlistDTO> wishlistall(String custid) throws Exception {
		return mapper.wishlistall(custid);
	}
	public int addCart(WishlistDTO cart) {

		// 장바구니 데이터 체크
		WishlistDTO checkCart = mapper.checkCart(cart);
		
		if(checkCart != null) {
			return 2;
		}
		
		// 장바구니 등록 & 에러 시 0반환
		try {
			return mapper.addCart(cart);
		} catch (Exception e) {
			return 0;
		}		
		
	}	
}
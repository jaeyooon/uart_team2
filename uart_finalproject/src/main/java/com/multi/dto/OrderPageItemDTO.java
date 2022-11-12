package com.multi.dto;

import java.util.Date;
import java.util.List;

public class OrderPageItemDTO {
	
	/* 뷰로부터 전달받을 값 */
    private Integer itemid;
    
    private Integer itemcnt1;
    private Integer itemcnt2;
    private Integer itemcnt3;
    
	/* DB로부터 꺼내올 값 */
    private String itemname;
    
    private Integer price1;
    private Integer price2;
    private Integer price3;
    

    
    
	/* 만들어 낼 값 */
    private Integer semiprice1;
    private Integer semiprice2;
    private Integer semiprice3;
    
    private Integer totalPrice;
    
	
    
}

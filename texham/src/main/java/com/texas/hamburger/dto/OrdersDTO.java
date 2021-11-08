package com.texas.hamburger.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
public class OrdersDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderId;
	private String userId;
	private String branchId;
	private List<String> items;
	private BigDecimal price;
	private String orderTime;
	private String orderStatus;

}

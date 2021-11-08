package com.texas.hamburger.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;


@Getter
@Setter
public class MenuDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String m_id;
	private String m_name;
	private String m_availablity;
	private BigDecimal m_price;

}

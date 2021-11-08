package com.texas.hamburger.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class BranchesDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String b_id;
	private String b_name;
	private String b_address;
	private String b_city;
	private String b_state;
	private String b_zipcode;
	private String b_status;
}

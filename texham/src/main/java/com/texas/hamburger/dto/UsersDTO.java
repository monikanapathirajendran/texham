package com.texas.hamburger.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class UsersDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String u_firstname;
	private String u_lastname;
	private String u_role;
	private String u_email;
	private String u_mobile;
	private String u_password;
	private String u_address;
	private String u_city;
	private String u_state;
	private String u_zipcode;
	private String u_status;
}

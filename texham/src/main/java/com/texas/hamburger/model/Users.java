package com.texas.hamburger.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection="users")

public class Users {
	@Id
	
	private String u_id;
	@Indexed(unique=true)
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

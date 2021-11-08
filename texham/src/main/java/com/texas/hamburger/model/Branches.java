package com.texas.hamburger.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection="branches")

public class Branches {
	@Id
	private String b_id;
	@Indexed(unique=true)
	private String b_name;
	private String b_address;
	private String b_city;
	private String b_state;
	private String b_zipcode;
	private String b_status;
}

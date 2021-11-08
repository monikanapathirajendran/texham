package com.texas.hamburger.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection="menu")

public class Menu {
	@Id
	private String m_id;
	@Indexed(unique=true)
	private String m_name;
	
	private String m_availablity;
	private BigDecimal m_price;
}

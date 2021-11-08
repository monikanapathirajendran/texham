package com.texas.hamburger.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection="orders")

public class Orders {
	@Id
	private String orderId;
	@Indexed(unique=true)
	private String userId;
	private String branchId;
	private List<String> items;
	private BigDecimal price;
	private String orderTime;
	private String orderStatus;
}


package com.texas.hamburger.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class ReservationsDTO implements Serializable {
	
	private String id;
	private String eventName;
	private String dateofEvent;
	private int numberofPeople;
	private String email;
	private boolean status;
		
}

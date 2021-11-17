
package com.texas.hamburger.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection="interceptor")
public class Interceptor {
	
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
	private long executionTime;
	private String url;
	private String urlDate;

}

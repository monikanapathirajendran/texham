
package com.texas.hamburger.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.texas.hamburger.model.Interceptor;


@Repository
public interface InterceptorRepository extends MongoRepository <Interceptor,Long>{
	List<Interceptor> findByUrlDateContaining(String urlDate);
	List<Interceptor> findByUrlContaining(String url);
}

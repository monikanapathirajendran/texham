package com.texas.hamburger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.texas.hamburger.model.Interceptor;
import com.texas.hamburger.repository.InterceptorRepository;
import com.texas.hamburger.repository.MenuRepository;


public class InterceptorService {

	@Autowired
	private InterceptorRepository interceptorRepository;
	
	public InterceptorService(InterceptorRepository interceptorRepository) {
	        this.interceptorRepository = interceptorRepository;
	    }

	public Interceptor storeInterceptor(Interceptor interceptor) {
		return interceptorRepository.save(interceptor);
	}

	
	public List<Interceptor> getInterceptorByName(String urlName) {
		List<Interceptor> interceptor = interceptorRepository.findByUrlContaining(urlName);
		return (interceptor.isEmpty())?null:interceptor;
	}


	public List<Interceptor> getInterceptorByDate(String urlDate) {
		List<Interceptor> interceptor = interceptorRepository.findByUrlDateContaining(urlDate);
		return interceptor.isEmpty()?null:interceptor;
	}
}


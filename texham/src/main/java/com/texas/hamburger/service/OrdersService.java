package com.texas.hamburger.service;


import lombok.NoArgsConstructor;

import com.texas.hamburger.exception.BranchesServiceException;
import com.texas.hamburger.exception.OrdersServiceException;
import com.texas.hamburger.model.Branches;
import com.texas.hamburger.model.Orders;
import com.texas.hamburger.repository.OrdersRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.texas.hamburger.dto.OrdersDTO;

import java.awt.MenuItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
@Service
@NoArgsConstructor
public class OrdersService   {

    private OrdersRepository ordersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }
    
    
    public Boolean add(OrdersDTO ordersDTO) {
        try{
            Orders orders = new Orders();
            BeanUtils.copyProperties(ordersDTO, orders);
           ordersRepository.insert(orders);
        }
        catch (Exception e){
            throw new OrdersServiceException("Internal Server Error",e);
        }
        return true;
    }

    public List<Orders> getAll() {
	        try{
	            return ordersRepository.findAll();
	        }
	        catch (Exception e){
	            throw new OrdersServiceException("Internal Server Error",e);
	        }
	    }
	 	
    public Map<String, Object> getAllByPageSize(int page, int size) { 
		  try {
	  List<Orders> orders = new ArrayList<Orders>(); 
	  Pageable paging =PageRequest.of(page-1,size);
	  
	  Page<Orders> order = ordersRepository.findAll(paging);
	  orders =	  order.getContent(); Map<String, Object> response = new HashMap<>();
	  
	  response.put("Items", orders); response.put("currentPage",
			  order.getNumber()+1); response.put("totalItems", order.getTotalElements());
	  response.put("totalPages", order.getTotalPages());
	  
	  return response; } catch (Exception e) { throw new
	  BranchesServiceException("Branch Not Found", e); } }


   
}


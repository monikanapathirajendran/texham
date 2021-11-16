package com.texas.hamburger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import lombok.NoArgsConstructor;


import com.texas.hamburger.service.OrdersService;
import com.texas.hamburger.exception.OrdersServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.util.EnumUtils;

import com.texas.hamburger.dto.OrdersDTO;
import com.texas.hamburger.model.Orders;
import com.texas.hamburger.response.Response;
import com.texas.hamburger.response.ResponseMetadata;
import com.texas.hamburger.response.StatusMessage;

import java.awt.MenuItem;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@SuppressWarnings("unused")
@RestController
@RequestMapping("api/orders")
@NoArgsConstructor
public class OrdersController {
	
	
	private OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService){
        this.ordersService = ordersService;
    }

    @PostMapping("/add")
    public Response<String> add(@RequestBody OrdersDTO order){
        return ordersService.add(order) == Boolean.TRUE ?
                Response.<String>builder()
                        .meta(ResponseMetadata.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.SUCCESS.name()).build())
                        .data("Orderadded")
                        .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetadata.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name()).build())
                        .data("Order not added")
                        .build();
    }
    
    @GetMapping(value="/getAll",produces = "application/json")
    public Response<List<Orders>> getAll(){
        return Response.<List<Orders>>builder()
                .meta(ResponseMetadata.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((ordersService.getAll()))
                .build();
    }
    

    @GetMapping(value="/getAll/{page}/{size}",produces = "application/json")
	  public Response<Map<String, Object>> getAllByPageSize(@PathVariable int page, @PathVariable int size){
		 
	  return Response.<Map<String, Object>>builder()
	  .meta(ResponseMetadata.builder() .statusCode(200)
	  .statusMessage(StatusMessage.SUCCESS.name()).build())
	  .data((ordersService.getAllByPageSize(page,size))) .build(); 
		  }
	 


}

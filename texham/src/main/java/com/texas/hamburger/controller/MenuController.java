package com.texas.hamburger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import lombok.NoArgsConstructor;


import com.texas.hamburger.service.MenuService;
/*import com.texas.hamburger.service.DeleteMapping;
import com.texas.hamburger.service.GetMapping;
import com.texas.hamburger.service.MenuServiceException;
import com.texas.hamburger.service.PathVariable;*/



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.util.EnumUtils;

import com.texas.hamburger.dto.MenuDTO;
import com.texas.hamburger.model.Menu;
import com.texas.hamburger.response.Response;
import com.texas.hamburger.response.ResponseMetadata;
import com.texas.hamburger.response.StatusMessage;

import java.awt.MenuItem;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/menu")
@NoArgsConstructor
public class MenuController {
	
	
	private MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    @PostMapping("/add")
    public Response<String> add(@RequestBody MenuDTO menu){
        return menuService.add(menu) == Boolean.TRUE ?
                Response.<String>builder()
                        .meta(ResponseMetadata.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.SUCCESS.name()).build())
                        .data("Menu item added")
                        .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetadata.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name()).build())
                        .data("Menu item not added")
                        .build();
    }
    
    @GetMapping(value="/getAll",produces = "application/json")
    public Response<List<Menu>> getAll(){
        return Response.<List<Menu>>builder()
                .meta(ResponseMetadata.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((menuService.getAll()))
                .build();
    }
    




}

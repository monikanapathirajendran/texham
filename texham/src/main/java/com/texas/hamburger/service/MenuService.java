package com.texas.hamburger.service;


import lombok.NoArgsConstructor;

import com.texas.hamburger.exception.MenuServiceException;
import com.texas.hamburger.model.Menu;
import com.texas.hamburger.repository.MenuRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.texas.hamburger.dto.MenuDTO;

import java.awt.MenuItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
@Service
@NoArgsConstructor
public class MenuService   {

    private MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }
    
    
    public Boolean add(MenuDTO menuDTO) {
        try{
            Menu menu = new Menu();
            BeanUtils.copyProperties(menuDTO, menu);
            menuRepository.insert(menu);
        }
        catch (Exception e){
            throw new MenuServiceException("Internal Server Error",e);
        }
        return true;
    }

    public List<Menu> getAll() {
	        try{
	            return menuRepository.findAll();
	        }
	        catch (Exception e){
	            throw new MenuServiceException("Internal Server Error",e);
	        }
	    }
	 	
	


   
}


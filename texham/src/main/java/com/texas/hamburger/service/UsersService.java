package com.texas.hamburger.service;


import lombok.NoArgsConstructor;

import com.texas.hamburger.exception.BranchesServiceException;
import com.texas.hamburger.exception.UsersServiceException;
import com.texas.hamburger.model.Branches;
import com.texas.hamburger.model.Users;
import com.texas.hamburger.repository.UsersRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.texas.hamburger.dto.UsersDTO;

import java.awt.MenuItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
public class UsersService   {

    private UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    
    public Boolean addUsers(UsersDTO usersDTO) {
        try{
            Users users = new Users();
            BeanUtils.copyProperties(usersDTO, users);
            usersRepository.insert(users);
        }
        catch (Exception e){
            throw new UsersServiceException("Internal Server Error",e);
        }
        return true;
    }

    public List<Users> getAllUsers() {
        try{
            return usersRepository.findAll();
        }
        catch (Exception e){
            throw new BranchesServiceException("Internal Server Error",e);
        }
    }

 



   
}


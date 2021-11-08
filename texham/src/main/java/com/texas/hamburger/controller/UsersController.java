package com.texas.hamburger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import lombok.NoArgsConstructor;
import com.texas.hamburger.service.UsersService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.util.EnumUtils;

import com.texas.hamburger.dto.UsersDTO;
import com.texas.hamburger.model.Branches;
import com.texas.hamburger.model.Users;
import com.texas.hamburger.response.Response;
import com.texas.hamburger.response.ResponseMetadata;
import com.texas.hamburger.response.StatusMessage;



import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/users")
@NoArgsConstructor
public class UsersController {
	
	
	private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @PostMapping("/addUser")
    public Response<String> addUsers(@RequestBody UsersDTO users){
        return usersService.addUsers(users) == Boolean.TRUE ?
                Response.<String>builder()
                        .meta(ResponseMetadata.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.SUCCESS.name()).build())
                        .data("User added")
                        .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetadata.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name()).build())
                        .data("User not added")
                        .build();
    }

    @GetMapping(value="/getAll",produces = "application/json")
    public Response<List<Users>> getAllUsers(){
        return Response.<List<Users>>builder()
                .meta(ResponseMetadata.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((usersService.getAllUsers()))
                .build();
    }
}

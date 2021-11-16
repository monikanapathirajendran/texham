package com.texas.hamburger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import com.texas.hamburger.service.BranchesService;
/*import com.texas.hamburger.service.DeleteMapping;
import com.texas.hamburger.service.GetMapping;
import com.texas.hamburger.service.MenuServiceException;
import com.texas.hamburger.service.PathVariable;*/



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.util.EnumUtils;

import com.texas.hamburger.dto.BranchesDTO;
import com.texas.hamburger.model.Branches;
import com.texas.hamburger.response.Response;
import com.texas.hamburger.response.ResponseMetadata;
import com.texas.hamburger.response.StatusMessage;

import java.awt.MenuItem;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/branches")
@NoArgsConstructor
@Log4j2
public class BranchesController {
	
	
	private BranchesService branchesService;

    @Autowired
    public BranchesController(BranchesService branchesService){
        this.branchesService = branchesService;
    }

    @PostMapping("/add")
    public Response<String> addBranch(@RequestBody BranchesDTO branches){
    	log.info("Add Branch invoked");
        return branchesService.addBranch(branches) == Boolean.TRUE ?
                Response.<String>builder()
                        .meta(ResponseMetadata.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.SUCCESS.name()).build())
                        .data("Branch added")
                        .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetadata.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name()).build())
                        .data("Branch not added")
                        .build();
    }
    
    @GetMapping(value="/getAll",produces = "application/json")
    public Response<List<Branches>> getAllBranches(){
        return Response.<List<Branches>>builder()
                .meta(ResponseMetadata.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((branchesService.getAllBranches()))
                .build();
    }

	  @GetMapping(value="/getAll/{page}/{size}",produces = "application/json")
	  public Response<Map<String, Object>> getAllByPageSize(@PathVariable int page, @PathVariable int size){
		 
	  return Response.<Map<String, Object>>builder()
	  .meta(ResponseMetadata.builder() .statusCode(200)
	  .statusMessage(StatusMessage.SUCCESS.name()).build())
	  .data((branchesService.getAllByPageSize(page,size))) .build(); 
		  }
	 

}

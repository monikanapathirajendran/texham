package com.texas.hamburger.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.texas.hamburger.dto.ReservationsDTO;
import com.texas.hamburger.model.Reservations;
import com.texas.hamburger.response.Response;
import com.texas.hamburger.response.ResponseMetadata;
import com.texas.hamburger.response.StatusMessage;
import com.texas.hamburger.service.ReservationsService;

import io.swagger.annotations.ApiOperation;

@NoArgsConstructor
@Log4j2
@RestController
@RequestMapping("/api/reservations")
public class ReservationsController {
	@Autowired
	ReservationsService reservationsService;
	
	   
    @GetMapping(value="/getAll",produces = "application/json")
    public Response<List<Reservations>> getAllReservations(){
        return Response.<List<Reservations>>builder()
                .meta(ResponseMetadata.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((reservationsService.getAllReservations()))
                .build();
    }
	


	 @PostMapping("/add")
	    public Response<String> addReservations(@RequestBody ReservationsDTO reservations){
	    	log.info("Add Reservation invoked");
	        return reservationsService.addReservations(reservations) == Boolean.TRUE ?
	                Response.<String>builder()
	                        .meta(ResponseMetadata.builder()
	                                .statusCode(200)
	                                .statusMessage(StatusMessage.SUCCESS.name()).build())
	                        .data("Reservation added")
	                        .build()
	                :
	                Response.<String>builder()
	                        .meta(ResponseMetadata.builder()
	                                .statusCode(200)
	                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name()).build())
	                        .data("Reservation not added")
	                        .build();
	    }
	 @PutMapping(value="/update/{id}/{status}",produces = "application/json")
	    public Response<Reservations> updateReservationById(@PathVariable String id, @PathVariable boolean status){
	        return Response.<Reservations>builder()
	                .meta(ResponseMetadata.builder()
	                        .statusCode(200)
	                        .statusMessage(StatusMessage.SUCCESS.name()).build())
	                .data((reservationsService.updateReservationById(id,status)))
	                .build();
	    }

	
	  @DeleteMapping(value="/remove/{id}/",produces = "application/json")
	  public Response<String> deleteReservationById(@PathVariable String id){
		  return Response.<String>builder()
	  .meta(ResponseMetadata.builder() .statusCode(200)
	  .statusMessage(StatusMessage.SUCCESS.name()).build())
	  .data((reservationsService.deleteReservationById(id))) .build();
		  
	  }
	 

}

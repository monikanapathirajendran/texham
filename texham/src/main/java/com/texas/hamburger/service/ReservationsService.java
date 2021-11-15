package com.texas.hamburger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texas.hamburger.exception.ReservationsServiceException;
import com.texas.hamburger.exception.BranchesServiceException;
import com.texas.hamburger.exception.NoDataFoundException;
import com.texas.hamburger.model.Branches;
import com.texas.hamburger.model.Reservations;
import com.texas.hamburger.repository.ReservationsRepository;


import com.texas.hamburger.dto.ReservationsDTO;

import java.awt.MenuItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReservationsService  {
	
	@Autowired
	 private ReservationsRepository reservationsRepository;


	public Boolean addReservations(ReservationsDTO reservationsDTO) {
        try{
        	Reservations reservations = new Reservations();
            BeanUtils.copyProperties(reservationsDTO, reservations);
            reservationsRepository.insert(reservations);
        }
        catch (Exception e){
            throw new BranchesServiceException("Internal Server Error",e);
        }
        return true;
    }


	public List<Reservations> getAllReservations() {
		  try{
	            return reservationsRepository.findAll();
	        }
	        catch (Exception e){
	            throw new ReservationsServiceException("Internal Server Error",e);
	        }
	    }

	public Reservations updateReservationById(String id, boolean status) {
        try {
            Optional<Reservations> reservation = reservationsRepository.findById(id);
           
                reservation.get().setStatus(status);
            reservationsRepository.save(reservation.get());
            return reservation.get();
        } catch (Exception e) {
            throw new ReservationsServiceException("Reservation Not Found", e);
        }
    }
	
	  public String deleteReservationById(String id) {
	        try {
	            Optional<Reservations> reservations = reservationsRepository.findById(id);
	            
	            reservationsRepository.deleteById(id);
	            return "Removed Successfully";
	        } catch (Exception e) {
	            throw new ReservationsServiceException("Reservation Not Found", e);
	        }


	  }
}

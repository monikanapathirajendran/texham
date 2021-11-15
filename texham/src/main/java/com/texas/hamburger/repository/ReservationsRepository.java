package com.texas.hamburger.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.texas.hamburger.model.Reservations;

@Repository
public interface ReservationsRepository extends MongoRepository<Reservations, String> {
	
	Optional<Reservations> findById(String id);
	void deleteById(String id);

}

package com.texas.hamburger.repository;

import com.texas.hamburger.model.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrdersRepository extends MongoRepository<Orders,String> {

}




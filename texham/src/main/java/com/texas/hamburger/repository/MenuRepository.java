package com.texas.hamburger.repository;

import com.texas.hamburger.model.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuRepository extends MongoRepository<Menu,String> {

}




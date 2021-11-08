package com.texas.hamburger.repository;

import com.texas.hamburger.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users,String> {

}




package com.texas.hamburger.repository;

import com.texas.hamburger.model.Branches;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BranchesRepository extends MongoRepository<Branches,String> {
	/* List<Branches> findAllByName(String b_name); */
	/* String deleteBranchByName(String b_name); */
	}






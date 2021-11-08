package com.texas.hamburger.service;


import lombok.NoArgsConstructor;

import com.texas.hamburger.exception.BranchesServiceException;
import com.texas.hamburger.model.Branches;
import com.texas.hamburger.repository.BranchesRepository;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.texas.hamburger.dto.BranchesDTO;


import java.awt.MenuItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
public class BranchesService   {

    private BranchesRepository branchesRepository;

    @Autowired
    public BranchesService(BranchesRepository branchesRepository) {
        this.branchesRepository = branchesRepository;
    }
    
    
    public Boolean addBranch(BranchesDTO branchesDTO) {
        try{
            Branches branches = new Branches();
            BeanUtils.copyProperties(branchesDTO, branches);
            branchesRepository.insert(branches);
        }
        catch (Exception e){
            throw new BranchesServiceException("Internal Server Error",e);
        }
        return true;
    }

    public List<Branches> getAllBranches() {
	        try{
	            return branchesRepository.findAll();
	        }
	        catch (Exception e){
	            throw new BranchesServiceException("Internal Server Error",e);
	        }
	    }
	 	
	/*
	 * public String deleteBranchByName(String b_name) { try { List<Branches> branch
	 * = branchesRepository.findAllByName(b_name); if(branch.size() == 1)
	 * branchesRepository.deleteBranchByName(b_name); return "Branch deleted "; }
	 * catch (Exception e) { throw new BranchesServiceException("Branch Not Found",
	 * e); } }
	 */


	/*
	 * public Map<String, Object> getAllByPageSize(int page, int size) { try {
	 * List<Branches> branches = new ArrayList<Branches>(); Pageable paging =
	 * PageRequest.of(page-1,size);
	 * 
	 * Page<Branches> branch = branchesRepository.findAll(paging); branches =
	 * branch.getContent(); Map<String, Object> response = new HashMap<>();
	 * 
	 * response.put("Items", branches); response.put("currentPage",
	 * branch.getNumber()+1); response.put("totalItems", branch.getTotalElements());
	 * response.put("totalPages", branch.getTotalPages());
	 * 
	 * return response; } catch (Exception e) { throw new
	 * BranchesServiceException("Branch Not Found", e); } }
	 */
 



   
}


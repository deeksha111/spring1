package com.cognizant.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbank.model.DonorFeedBack;
@Repository
public interface DonorFeedBackRepository extends JpaRepository<DonorFeedBack, Integer> {
	
	
	
	

}

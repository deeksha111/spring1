package com.cognizant.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bloodbank.model.DonorFeedBack;
import com.cognizant.bloodbank.repository.DonorFeedBackRepository;
@Service
public class DonorFeedBackService {
@Autowired
DonorFeedBackRepository donorFeedBackRepository;
	
	public DonorFeedBack getfeedback(DonorFeedBack donorFeedBack) {
		// TODO Auto-generated method stub
	return donorFeedBackRepository.save(donorFeedBack);	
	}

	

}

package com.cognizant.bloodbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bloodbank.model.BloodRequest;
import com.cognizant.bloodbank.model.DonorFeedBack;
import com.cognizant.bloodbank.service.DonorFeedBackService;

@RestController
public class DonorFeedBackController {
	
	@Autowired
	DonorFeedBackService donorFeedBackService;
	
	@PostMapping("/feedback") 

	public void getfeedback(@RequestBody  DonorFeedBack donorFeedBack)

	{
		donorFeedBackService.getfeedback(donorFeedBack);
		
	}

}

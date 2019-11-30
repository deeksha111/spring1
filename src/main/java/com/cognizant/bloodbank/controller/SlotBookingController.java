package com.cognizant.bloodbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bloodbank.model.Slot;
import com.cognizant.bloodbank.service.SlotBookingService;

@RestController
public class SlotBookingController {

	@Autowired
	SlotBookingService slotBookingService;

	/*
	 * @GetMapping("/hospitals/{pincode}") public List<Hospitals>
	 * getHospitals(@PathVariable int pincode){ return
	 * slotBookingService.getHospitals(pincode);
	 * 
	 * }
	 */

	@GetMapping("/hospitals/{pincode}")
	public List<String> getHospitals(@PathVariable int pincode) {
		return slotBookingService.donors(pincode);
	}

	@PostMapping("/slot")
	public void postSlot(@RequestBody Slot slotBooking) {
		slotBookingService.postSlot(slotBooking);
	}

	@GetMapping("/hospitalid/{name}/{pincode}")
	public int getHospitalId(@PathVariable String name, @PathVariable int pincode) {
		return slotBookingService.hospitalId(name, pincode);
	}

	@PostMapping("/hospital/slot/{username}")
	public boolean getUserById(@RequestBody Slot slotBooking,@PathVariable("username") String user2) {
		return slotBookingService.getUserById(slotBooking.getHospitalName(), slotBooking.getTime(),
				slotBooking.getSlot(),user2);
	}

}

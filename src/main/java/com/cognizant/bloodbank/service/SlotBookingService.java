package com.cognizant.bloodbank.service;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bloodbank.model.Hospitals;
import com.cognizant.bloodbank.model.Slot;
import com.cognizant.bloodbank.model.SlotBooking;
import com.cognizant.bloodbank.model.User;
import com.cognizant.bloodbank.repository.HospitalRepository;
import com.cognizant.bloodbank.repository.SlotBookingRepository;
import com.cognizant.bloodbank.repository.UserRepository;
@Service
public class SlotBookingService {

	
	@Autowired
	SlotBookingRepository slotBookingRepository;
	
	@Autowired
	HospitalRepository hospitalRepository;
	@Autowired
	UserRepository userRepository;
	
	public List<String> getHospitals(int pincode){
		return hospitalRepository.getHospitalList(pincode);
		
	}
	
//	public List<String> donors(int pincode){
//		 List<String> hospitals=hospitalRepository.getHospitalList(pincode);
//		 List<String> hospitalname = new ArrayList<>();
//		 for (Hospitals h  : hospitals) {
//			 hospitalname.add(h.getName());
//			
//		}
//		 return hospitalname;
//	}
	public List<String> donors(int pincode){
		 List<String> hospitals=hospitalRepository.getHospitalList(pincode);
		return hospitals;
	}

	public void postSlot(Slot slotBooking)
	{
		String username=slotBooking.getHospitalName().substring(3);
		Hospitals hospitals=hospitalRepository.findByName(username);
		System.err.println(username);
		SlotBooking booking = new SlotBooking();
		System.err.println(hospitals);
		booking.setHospitals(hospitals);
		booking.setDate(slotBooking.getTime());
		booking.setTime(slotBooking.getSlot());
		slotBookingRepository.save(booking);
	
	}
	
	public int hospitalId(String name,int pincode){
		return hospitalRepository.getHospitalId(name, pincode);
	}
	
//	public SlotBooking getSlots() {
//		
//	}

	public boolean getUserById(String user1, Date d1, String time,String user2) {
		// TODO Auto-generated method stub
		System.err.println("Game"+user1);
		String username=user1.substring(3);
		System.err.println(""+username);
		List<SlotBooking> booking = slotBookingRepository.findAll();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String passdate = dateFormat.format(d1);
		if(!booking.isEmpty()){
			for(SlotBooking slotBooking : booking){
				Date d = slotBooking.getDate();
				String date = dateFormat.format(d);
				if(date.equals(passdate) && time.equals(slotBooking.getTime())){
					return false;
				}
			}
			Hospitals hospitals = hospitalRepository.findByName(username);
			System.err.println(" hello"+hospitals);
			SlotBooking slotBooking2 = new SlotBooking();
			slotBooking2.setId(1);
			slotBooking2.setHospitals(hospitals);
			slotBooking2.setDate(d1);
			slotBooking2.setTime(time);
			System.err.println("fdhfh"+slotBooking2);
			Set<SlotBooking> bookings = new HashSet<>();
			bookings.add(slotBooking2);
			User user = userRepository.findByFirstname(user2);
			user.setSlotList(bookings);
			userRepository.save(user);
			return true;
		}
		else{
			return false;
		}
	}
	

}

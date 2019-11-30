package com.cognizant.bloodbank.model;

import java.util.Date;

public class Slot {
	private String hospitalName;
	private String slot;
	private Date time;
	public Slot() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Slot(String hospitalName, String slot, Date time) {
		super();
		this.hospitalName = hospitalName;
		this.slot = slot;
		this.time = time;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Slot [hospitalName=" + hospitalName + ", slot=" + slot + ", time=" + time + "]";
	}
	
}

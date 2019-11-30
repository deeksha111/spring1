package com.cognizant.bloodbank.model;

import java.sql.Time;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "slot_booking")
public class SlotBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sl_id")
	private int id;
	
	public SlotBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SlotBooking(int id, Date date, String time, Hospitals hospitals) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.hospitals = hospitals;
	}

	@Override
	public String toString() {
		return "SlotBooking [id=" + id + ", date=" + date + ", time=" + time + ", hospitals=" + hospitals + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Hospitals getHospitals() {
		return hospitals;
	}

	public void setHospitals(Hospitals hospitals) {
		this.hospitals = hospitals;
	}

	@Column(name = "sl_date")
	private Date date;
	
	@Column(name = "sl_time")
	private String time;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="sl_hp_id_fk", referencedColumnName="hp_id")
	private Hospitals hospitals; 
	
	@ManyToMany(mappedBy="slotList")
	private Set<User> users;

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}

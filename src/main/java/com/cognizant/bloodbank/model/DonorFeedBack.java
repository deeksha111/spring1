package com.cognizant.bloodbank.model;

import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "donor_feedback")
public class DonorFeedBack {
	public DonorFeedBack() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DonorFeedBack(int id, String feedback, Hospitals hospitals) {
		super();
		this.id = id;
		this.feedback = feedback;
	
	}

	@Override
	public String toString() {
		return "DonorFeedBack [id=" + id + ", feedback=" + feedback + ", hpname=" + hpname + ", hparea=" + hparea + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "df_id")
	private int id;
	
	@Column(name = "df_feedback")
	private String feedback;
	
	@Column(name = "df_hp_name")
	private String hpname;
	
	@Column(name = "df_hp_area")
	private String hparea;

	public DonorFeedBack(int id, String feedback, String hpname, String hparea) {
		super();
		this.id = id;
		this.feedback = feedback;
		this.hpname = hpname;
		this.hparea = hparea;
	}

	public String getHpname() {
		return hpname;
	}

	public void setHpname(String hpname) {
		this.hpname = hpname;
	}

	public String getHparea() {
		return hparea;
	}

	public void setHparea(String hparea) {
		this.hparea = hparea;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="df_us_id_fk", referencedColumnName="us_id")
	private User users; 
	
	
}

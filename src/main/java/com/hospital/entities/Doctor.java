package com.hospital.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Doctor {
	@Id
	int doctor_id;
	String name;
	String working_hours;
	String specialization;
	int contact_no;
	int experience_yrs;
	
	//@ColumnDefault(value = "'A'")
 	//char status;

	@Column(columnDefinition = "CHAR DEFAULT 'A'")
    char status;
	
	// constructors

	public Doctor() {

	}

	public Doctor(int doctor_id, String name, String working_hours, String specialization, int contact_no,
			int experience_yrs, char status) {
		super();
		this.doctor_id = doctor_id;
		this.name = name;
		this.working_hours = working_hours;
		this.specialization = specialization;
		this.contact_no = contact_no;
		this.experience_yrs = experience_yrs;
		this.status = status;
	}

	public Doctor(int doctor_id, String name, String working_hours, String specialization, int contact_no,
			int experience_yrs) {
		super();
		this.doctor_id = doctor_id;
		this.name = name;
		this.working_hours = working_hours;
		this.specialization = specialization;
		this.contact_no = contact_no;
		this.experience_yrs = experience_yrs;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorking_hours() {
		return working_hours;
	}

	public void setWorking_hours(String working_hours) {
		this.working_hours = working_hours;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getContact_no() {
		return contact_no;
	}

	public void setContact_no(int contact_no) {
		this.contact_no = contact_no;
	}

	public int getExperience_yrs() {
		return experience_yrs;
	}

	public void setExperience_yrs(int experience_yrs) {
		this.experience_yrs = experience_yrs;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Doctor [doctor_id=" + doctor_id + ", name=" + name + ", working_hours=" + working_hours
				+ ", specialization=" + specialization + ", contact_no=" + contact_no + ", experience_yrs="
				+ experience_yrs + ", status=" + status + "]";
	}
	
	
	

	
	
}
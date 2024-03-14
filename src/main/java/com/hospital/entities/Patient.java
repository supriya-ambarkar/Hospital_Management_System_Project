package com.hospital.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "Patient")

public class Patient {
	@Id
	int patient_id;
	String name;
	String gender;
	int age;
	int contact_no;


	@Column(columnDefinition = "CHAR DEFAULT 'A'")
    char status;

	//@Enumerated(EnumType.STRING)
	//PatientType patientType; // in patient/out patient

	// doctor many to one
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	// Default constructor

	public Patient() {

	}

	public Patient(int patient_id, String name, String gender, int age, int contact_no, char status,Doctor doctor) {
		super();
		this.patient_id = patient_id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.contact_no = contact_no;
		this.status = status;
		
		this.doctor = doctor;
	}

	public Patient(int patient_id, String name, String gender, int age, int contact_no) {
		super();
		this.patient_id = patient_id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.contact_no = contact_no;

	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getContact_no() {
		return contact_no;
	}

	public void setContact_no(int contact_no) {
		this.contact_no = contact_no;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Patient [patient_id=" + patient_id + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", contact_no=" + contact_no + ", status=" + status + ", doctor="
				+ doctor + "]";
	}

	//public enum PatientType {
		//INPATIENT, OUTPATIENT
	//}

}
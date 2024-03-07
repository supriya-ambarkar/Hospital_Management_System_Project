package com.hospital.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Operations {
	@Id
	int admission_id;
	Date admissionDate;
	int alloted_room;
	String admission_reason;
	Date discharge_date;
	// int patient_id; // fk

	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	Patient patient;

	// constructors

	public Operations() {

	}

	public Operations(int admission_id, Date admissionDate, int alloted_room, String admission_reason,
			Patient patient) {
		super();
		this.admission_id = admission_id;
		this.admissionDate = admissionDate;
		this.alloted_room = alloted_room;
		this.admission_reason = admission_reason;
		this.patient = patient;
	}

	public Operations(int admission_id, Date admissionDate, int alloted_room, String admission_reason,
			Date discharge_date) {
		super();
		this.admission_id = admission_id;
		this.admissionDate = admissionDate;
		this.alloted_room = alloted_room;
		this.admission_reason = admission_reason;
		this.discharge_date = discharge_date;

	}

	public int getAdmission_id() {
		return admission_id;
	}

	public void setAdmission_id(int admission_id) {
		this.admission_id = admission_id;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public int getAlloted_room() {
		return alloted_room;
	}

	public void setAlloted_room(int alloted_room) {
		this.alloted_room = alloted_room;
	}

	public String getAdmission_reason() {
		return admission_reason;
	}

	public void setAdmission_reason(String admission_reason) {
		this.admission_reason = admission_reason;
	}

	public Date getDischarge_date() {
		return discharge_date;
	}

	public void setDischarge_date(Date discharge_date) {
		this.discharge_date = discharge_date;
	}

	@Override
	public String toString() {
		return "Operations [admission_id=" + admission_id + ", admissionDate=" + admissionDate + ", alloted_room="
				+ alloted_room + ", admission_reason=" + admission_reason + ", discharge_date=" + discharge_date + "]";
	}

}

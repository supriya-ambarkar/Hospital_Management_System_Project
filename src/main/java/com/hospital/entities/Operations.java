package com.hospital.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Operations {
	@Id
	int admission_id;
	String admissionDate;
	int alloted_room;
	String admission_reason;
	String discharge_date;

	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	Patient patient;

	@Column(columnDefinition = "CHAR DEFAULT 'A'")
	char status;

	// constructors

	public Operations() {

	}

	public Operations(int admission_id, String admissionDate, int alloted_room, String admission_reason,
			String discharge_date, Patient patient, char status) {
		super();
		this.admission_id = admission_id;
		this.admissionDate = admissionDate;
		this.alloted_room = alloted_room;
		this.admission_reason = admission_reason;
		this.discharge_date = discharge_date;
		this.patient = patient;
		this.status = status;
	}

	public Operations(int admission_id, String admissionDate, int alloted_room, String admission_reason,
			String discharge_date) {
		super();
		this.admission_id = admission_id;
		this.admissionDate = admissionDate;
		this.alloted_room = alloted_room;
		this.admission_reason = admission_reason;
		this.discharge_date = discharge_date;
	}

	public Operations(int admission_id, int alloted_room, String admission_reason, String discharge_date) {
		super();
		this.admission_id = admission_id;
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

	public String getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(String admissionDate) {
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

	public String getDischarge_date() {
		return discharge_date;
	}

	public void setDischarge_date(String discharge_date) {
		this.discharge_date = discharge_date;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Operations [admission_id=" + admission_id + ", admissionDate=" + admissionDate + ", alloted_room="
				+ alloted_room + ", admission_reason=" + admission_reason + ", discharge_date=" + discharge_date
				+ ", patient=" + patient + ", status=" + status + "]";
	}

}

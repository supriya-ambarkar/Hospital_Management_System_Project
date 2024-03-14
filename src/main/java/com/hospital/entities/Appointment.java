package com.hospital.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Appointment {
	@Id
	int appointment_id;
	String appointmentDate;
	String reason;

	@Column(columnDefinition = "CHAR DEFAULT 'A'")
	char status;

	@ManyToOne
	@JoinColumn(name = "doctor_id", nullable = false)
	private Doctor doctor;

	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	private Patient patient;

	public Appointment() {

	}

	public Appointment(int appointment_id, String appointmentDate, String reason, char status, Doctor doctor,
			Patient patient) {
		super();
		this.appointment_id = appointment_id;
		this.appointmentDate = appointmentDate;
		this.reason = reason;
		this.status = status;
		this.doctor = doctor;
		this.patient = patient;
	}

	public Appointment(int appointment_id, String appointmentDate, String reason) {
		super();
		this.appointment_id = appointment_id;
		this.appointmentDate = appointmentDate;
		this.reason = reason;
	}

	public Appointment(int appointment_id, String appointmentDate, String reason, Doctor doctor, Patient patient) {
		super();
		this.appointment_id = appointment_id;
		this.appointmentDate = appointmentDate;
		this.reason = reason;
		this.doctor = doctor;
		this.patient = patient;
	}

	public int getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Appointment [appointment_id=" + appointment_id + ", appointmentDate=" + appointmentDate + ", reason="
				+ reason + ", status=" + status + ", doctor=" + doctor + ", patient=" + patient + "]";
	}

}
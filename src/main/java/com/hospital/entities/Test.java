package com.hospital.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Test {
	@Id
	int test_id;
	String testName;

	String results;

	@Column(columnDefinition = "CHAR DEFAULT 'A'")
    char status;

	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	Patient patient;

	@ManyToOne
	@JoinColumn(name = "doctorId")
	Doctor doctor;

	// constructors
	public Test() {

	}

	public Test(int test_id, String testName, String results, char status, Patient patient, Doctor doctor) {
		super();
		this.test_id = test_id;
		this.testName = testName;
		this.results = results;
		this.status = status;
		this.patient = patient;
		this.doctor = doctor;
	}

	public Test(int test_id, String testName, String results) {
		super();
		this.test_id = test_id;
		this.testName = testName;
		this.results = results;
	}

	public int getTest_id() {
		return test_id;
	}

	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Test [test_id=" + test_id + ", testName=" + testName + ", results=" + results + ", status=" + status
				+ ", patient=" + patient + ", doctor=" + doctor + "]";
	}

}

package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Test {
	@Id
	int test_id;
	// int patient_id; //fk
	String testName;
	String status;
	String results;

	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	Patient patient;

	@ManyToOne
	@JoinColumn(name = "doctorId")
	Doctor doctor;

	// constructors
	public Test() {

	}

	public Test(int test_id, String testName, Patient patient, Doctor doctor) {
		super();
		this.test_id = test_id;
		this.testName = testName;
		this.patient = patient;
		this.doctor = doctor;
	}

	public Test(int test_id, String testName, String status, String results) {
		super();
		this.test_id = test_id;

		this.testName = testName;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "Test [test_id=" + test_id + ", testName=" + testName + ", status=" + status + ", results=" + results
				+ "]";
	}

}

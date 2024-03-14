package com.hospital.dao;

import java.util.List;

import com.hospital.entities.Doctor;

public interface DoctorDAO {

	boolean saveDoctor(Doctor doctor);

	Doctor findDoctorById(int doctorId);

	List<Doctor> getAllDoctors();

	boolean updateDoctorById(int doctor_id, String name, String working_hours, String specialization, int contact_no,
			int experience_yrs);

	boolean deleteDoctor(int doctorId);

}
package com.hospital.service;

import java.util.List;

import com.hospital.entities.Appointment;
import com.hospital.entities.Doctor;
import com.hospital.entities.Patient;

public interface DoctorService {
	
	
	void saveDoctor(Doctor doctor);

    Doctor findDoctorById(int doctorId);

    List<Doctor> getAllDoctors();

    Doctor updateDoctorById(int id,String newName, String newSpecialization, int newContact,String newMedicines,int updateExperience);

    void deleteDoctor(int doctorId);
}

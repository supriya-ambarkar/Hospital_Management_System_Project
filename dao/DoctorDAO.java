package com.hospital.dao;

import java.util.List;

import com.hospital.entities.Doctor;

public interface DoctorDAO {

    void saveDoctor(Doctor doctor);

    Doctor findDoctorById(int doctorId);

    List<Doctor> getAllDoctors();

    Doctor updateDoctorById(int id,String newName, String newSpecialization, int newContact,String newMedicines,int updateExperience);

    void deleteDoctor(int doctorId);


}
package com.hospital.serviceImpl;

import java.util.List;

import com.hospital.dao.DoctorDAO;
import com.hospital.daoImpl.DoctorDAOImpl;
import com.hospital.entities.Doctor;
import com.hospital.service.DoctorService;

public class DoctorServiceImpl implements DoctorService {

	DoctorDAO doctorDAO = new DoctorDAOImpl();

	@Override
	public void saveDoctor(Doctor doctor) {
		doctorDAO.saveDoctor(doctor);
	}
	@Override
	public Doctor findDoctorById(int doctorId) {
		return doctorDAO.findDoctorById(doctorId);
	}
	@Override
	public List<Doctor> getAllDoctors() {
		return doctorDAO.getAllDoctors();
	}
	@Override
	public Doctor updateDoctorById(int id, String newName, String newSpecialization, int newContact,
			String newMedicines, int updateExperience) {
		return doctorDAO.updateDoctorById(id, newName, newSpecialization, newContact, newMedicines, updateExperience);

	}
	@Override
	public void deleteDoctor(int doctorId) {
		doctorDAO.deleteDoctor(doctorId);
	}

}

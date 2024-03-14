package com.hospital.service_impl;

import java.util.List;

import com.hospital.dao.DoctorDAO;
import com.hospital.dao_impl.DoctorDAOImpl;
import com.hospital.entities.Doctor;
import com.hospital.service.DoctorService;

public class DoctorServiceImpl implements DoctorService {

	DoctorDAO doctorDAO = new DoctorDAOImpl();

	@Override
	public boolean saveDoctor(Doctor doctor) {
		return doctorDAO.saveDoctor(doctor);

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
	public boolean updateDoctorById(int doctor_id, String name, String working_hours, String specialization,
			int contact_no, int experience_yrs) {
		return doctorDAO.updateDoctorById(doctor_id, name, working_hours, specialization, contact_no, experience_yrs);

	}

	@Override
	public boolean deleteDoctor(int doctorId) {
		return doctorDAO.deleteDoctor(doctorId);
	}

}

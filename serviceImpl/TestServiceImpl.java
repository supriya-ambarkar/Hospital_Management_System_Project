package com.hospital.serviceImpl;

import java.util.List;

import com.hospital.dao.TestDAO;
import com.hospital.daoImpl.TestDAOImpl;
import com.hospital.entities.Test;
import com.hospital.service.TestService;

public class TestServiceImpl  implements TestService{

	TestDAO testDAO = new TestDAOImpl();
	
	@Override
	public Test saveTest(Test test) {
		return testDAO.saveTest(test);
	}
	
	@Override
	public Test getTestById(int id) {
		return testDAO.getTestById(id);
	}
	@Override
	public 	List<Test> getAllTests(){
		return testDAO.getAllTests();
	}
	
	@Override
	public 	void updateTest(Test test) {
		testDAO.updateTest(test);
	}
	
	@Override 
	public  void deleteTest(int id) {
		testDAO.deleteTest(id);
	}
}

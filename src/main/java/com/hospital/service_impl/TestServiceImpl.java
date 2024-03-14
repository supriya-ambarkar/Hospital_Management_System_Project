package com.hospital.service_impl;

import java.util.List;

import com.hospital.dao.TestDAO;
import com.hospital.dao_impl.TestDAOImpl;
import com.hospital.entities.Test;
import com.hospital.service.TestService;

public class TestServiceImpl implements TestService {

	TestDAO testDAO = new TestDAOImpl();

	@Override
	public boolean saveTest(Test test) {
		return testDAO.saveTest(test);
	}

	@Override
	public Test getTestById(int id) {
		return testDAO.getTestById(id);
	}

	@Override
	public List<Test> getAllTests() {
		return testDAO.getAllTests();
	}

	@Override
	public boolean updateTest(int test_id, String testName, String results) {
		return testDAO.updateTest(test_id, testName, results);
	}

	@Override
	public boolean deleteTest(int id) {
		return testDAO.deleteTest(id);
	}
}

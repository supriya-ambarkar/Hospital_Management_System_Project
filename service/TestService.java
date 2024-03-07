package com.hospital.service;

import java.util.List;

import com.hospital.entities.Test;

public interface TestService {

	Test saveTest(Test test);

	Test getTestById(int id);

	List<Test> getAllTests();

	void updateTest(Test test);

	void deleteTest(int id);
}

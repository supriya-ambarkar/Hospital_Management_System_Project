package com.hospital.dao;

import java.util.List;

import com.hospital.entities.Patient;
import com.hospital.entities.Test;

public interface TestDAO {

    boolean saveTest(Test test);

    Test getTestById(int id);

    List<Test> getAllTests();

    boolean updateTest(int test_id, String testName, String results);

    boolean deleteTest(int id);
}


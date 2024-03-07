package com.hospital.dao;

import java.util.List;

import com.hospital.entities.Test;

public interface TestDAO {

    Test saveTest(Test test);

    Test getTestById(int id);

    List<Test> getAllTests();

    void updateTest(Test test);

    void deleteTest(int id);
}
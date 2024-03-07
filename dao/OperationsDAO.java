package com.hospital.dao;

import java.util.List;

import com.hospital.entities.Operations;

public interface OperationsDAO {

    Operations saveOperation(Operations operation);

    Operations getOperationById(int id);

    List<Operations> getAllOperations();

    void updateOperation(Operations operations);

    void deleteOperation(int id);
}
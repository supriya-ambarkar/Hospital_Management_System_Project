package com.hospital.service;

import java.util.List;

import com.hospital.entities.Operations;

public interface OperationsService {

	Operations saveOperation(Operations operation);

	Operations getOperationById(int id);

	List<Operations> getAllOperations();

	void updateOperation(Operations operations);

	void deleteOperation(int id);
}

package com.hospital.serviceImpl;

import java.util.List;

import com.hospital.dao.OperationsDAO;
import com.hospital.daoImpl.OperationsDAOImpl;
import com.hospital.entities.Operations;
import com.hospital.service.OperationsService;

public class OperationsServiceImpl implements OperationsService {
	OperationsDAO operationsDAO = new OperationsDAOImpl();

	@Override
	public Operations saveOperation(Operations operation) {
		return operationsDAO.saveOperation(operation);
	}

	@Override
	public Operations getOperationById(int id) {
		return operationsDAO.getOperationById(id);
	}

	@Override
	public List<Operations> getAllOperations() {
		return operationsDAO.getAllOperations();
	}

	@Override
	public void updateOperation(Operations operations) {
		operationsDAO.updateOperation(operations);
	}

	@Override
	public void deleteOperation(int id) {
		operationsDAO.deleteOperation(id);
	}
}

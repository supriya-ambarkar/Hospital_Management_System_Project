package com.hospital.service_impl;

import java.sql.Date;
import java.util.List;

import com.hospital.dao.OperationsDAO;
import com.hospital.dao_impl.OperationsDAOImpl;
import com.hospital.entities.Operations;
import com.hospital.service.OperationsService;

public class OperationsServiceImpl implements OperationsService {
	OperationsDAO operationsDAO = new OperationsDAOImpl();

	@Override
	public boolean saveOperation(Operations operation) {
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
	public boolean updateOperation(int admission_id, int alloted_room, String admission_reason, String discharge_date) {
		return operationsDAO.updateOperation(admission_id, alloted_room, admission_reason, discharge_date);
	}

	@Override
	public boolean deleteOperation(int id) {
		return operationsDAO.deleteOperation(id);
	}
}

package com.hospital.service;

import java.sql.Date;
import java.util.List;

import com.hospital.entities.Operations;

public interface OperationsService {

	boolean saveOperation(Operations operation);

	Operations getOperationById(int id);

	List<Operations> getAllOperations();

	boolean updateOperation(int admission_id, int alloted_room, String admission_reason, String discharge_date);

	boolean deleteOperation(int id);
}

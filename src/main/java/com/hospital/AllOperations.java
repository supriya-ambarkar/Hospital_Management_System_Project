package com.hospital;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import org.hibernate.ObjectDeletedException;
import org.junit.jupiter.api.condition.OS;

import com.hospital.entities.Appointment;
import com.hospital.entities.Doctor;
import com.hospital.entities.Operations;
import com.hospital.entities.Patient;
import com.hospital.entities.Test;
import com.hospital.service.AppointmentService;
import com.hospital.service.DoctorService;
import com.hospital.service.OperationsService;
import com.hospital.service.PatientService;
import com.hospital.service.TestService;
import com.hospital.service_impl.AppointmentServiceImpl;
import com.hospital.service_impl.DoctorServiceImpl;
import com.hospital.service_impl.OperationsServiceImpl;
import com.hospital.service_impl.PatientServiceImpl;
import com.hospital.service_impl.TestServiceImpl;

public class AllOperations {
	static AppointmentService appointmentService = new AppointmentServiceImpl();
	static DoctorService doctorService = new DoctorServiceImpl();
	static OperationsService operationsService = new OperationsServiceImpl();
	static PatientService patientService = new PatientServiceImpl();
	static TestService testService = new TestServiceImpl();

	static Scanner scanner = new Scanner(System.in);

	// 1. appointment inputs

	public static <T> T getEntityById(Scanner scanner, String entityType) {
		System.out.print("Enter " + entityType + " ID: ");
		int entityId = scanner.nextInt();
		return null;
	}
	

	public static Appointment appointmentInputs() {
		scanner.nextLine();
		System.out.println("Enter Appointment Id : ");
		int appointmentId = scanner.nextInt();

		System.out.println("Enter appointment date (YYYY-MM-DD): ");
		scanner.nextLine();
		String date = scanner.nextLine();
		

		System.out.println("Enter appointment description: ");
		String reason = scanner.nextLine();

		//Patient patient = getEntityById(scanner, "patient");
		System.out.println("Enter patient id : ");
		int patient_id = scanner.nextInt();
		Patient patient2 = patientService.getPatientById(patient_id);
		
		//Doctor doctor = getEntityById(scanner, "doctor");
		System.out.println("Enter doctor id : ");
		int doctor_id = scanner.nextInt();
		Doctor doctor = doctorService.findDoctorById(doctor_id);
		//System.out.println();
		

		return new Appointment(appointmentId, date, reason,'A', doctor, patient2);
	}

	// 2. doctor inputs

	public static Doctor doctorInputs() {
		scanner.nextLine();

		System.out.println("Enter doctor ID (numbers only): ");
		int doctorId = scanner.nextInt();

		System.out.println("Enter doctor's name: ");
		scanner.nextLine();
		String name = scanner.nextLine();
		
		System.out.println("Enter doctor's working hours (e.g., 9AM-5PM): ");
		//scanner.nextLine();
		String workingHours = scanner.nextLine();

		System.out.println("Enter doctor's specialization (e.g., Cardiology, ENT): ");
		String specialization = scanner.nextLine();

		System.out.println("Enter contact number (numbers only): ");
		int contact_no = scanner.nextInt();

		System.out.println("Enter doctor's experience in years (numbers only): ");
		int experienceYears = 0;
		try {
			experienceYears = scanner.nextInt();
			if (experienceYears < 0) {
				throw new IllegalArgumentException("Experience years cannot be negative.");
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a number for experience years.");
			scanner.nextLine();
		}

		//System.out.println("Enter the status");
		//char status = scanner.next().charAt(0);
		
		
		
		return new Doctor(doctorId, name, workingHours, specialization, contact_no, experienceYears,'A');

	}

	
	
	// 3. operations input

	public static Operations operationsInputs() {
		scanner.nextLine();

		// admission id
		System.out.println("Enter admission id: ");
		int admission_id = scanner.nextInt();

		// Admission Date
		System.out.println("Enter admission date (YYYY-MM-DD format): ");
		scanner.nextLine();
		String admissionDate = scanner.nextLine();
		
		// Date admissionDate = parseDate(admissionDateString);

		// Allotted Room
		System.out.println("Enter allotted room number: ");
		int allotted_room = scanner.nextInt();

		// Admission Reason
		System.out.println("Enter reason for admission: ");
		scanner.nextLine();
		String admission_reason = scanner.nextLine();
		

		// Discharge Date
		System.out.println("Enter discharge date (YYYY-MM-DD format) (optional, press Enter to skip): ");
		String dischargeDate = scanner.nextLine();
		//scanner.nextLine();
		
		// patient
		
		//Patient patient = getEntityById(scanner, "patient");
		
		System.out.println("Enter patient id : ");
		int patient_id = scanner.nextInt();
		Patient patient2 = patientService.getPatientById(patient_id);
		
		return new Operations(admission_id, admissionDate, allotted_room, admission_reason, dischargeDate, patient2, 'A');
	}

	private static Date parseDate(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return (Date) sdf.parse(dateString);
		} catch (ParseException e) {
			System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
			return null;
		}
	}

	// 4. patient inputs
	
	public static Patient patientInputs() {
		scanner.nextLine();
		System.out.println("Enter patient ID: ");
		int patient_id = scanner.nextInt();

		System.out.println("Enter patient name: ");
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.println(name);
		

		System.out.println("Enter patient gender (M/F): ");
		String gender = scanner.nextLine().toUpperCase();
		
		System.out.println("Enter patient age: ");
		int age = scanner.nextInt();

		System.out.println("Enter patient contact number: ");
		int contact_no = scanner.nextInt();
	
		
		// get doctor input
		
	//	Doctor doctor = getEntityById(scanner, "doctor");
		System.out.println("Enter doctor id : ");
		int doctor_id = scanner.nextInt();
		Doctor doctor = doctorService.findDoctorById(doctor_id);
		System.out.println();
		
		
		return new Patient(patient_id, name, gender, age, contact_no, 'A', doctor);
	//	return new Patient(patient_id, name, gender, age, contact_no);
	
      //  return new Patient(patient_id, name, gender, age, contact_no, 'A', patientTypeInput, doctor);
		
	}

	// 5. test inputs

	public static Test testInputs() {
		scanner.nextLine();

		System.out.println("Enter test ID: ");
		int test_id = scanner.nextInt();

		System.out.println("Enter test name: ");
		scanner.nextLine();
		String testName = scanner.nextLine();
		

		System.out.println("Enter test results :  ");
		String results = scanner.nextLine();
		
		// patient input
		//Patient patient = getEntityById(scanner, "patient");
		System.out.println("Enter patient id : ");
		int patient_id = scanner.nextInt();
		Patient patient2 = patientService.getPatientById(patient_id);
		
		
		// doctor input
		//Doctor doctor = getEntityById(scanner, "doctor");

		System.out.println("Enter doctor id : ");
		int doctor_id = scanner.nextInt();
		Doctor doctor = doctorService.findDoctorById(doctor_id);
		//System.out.println();
		
		
		return new Test(test_id, testName, results, 'A', patient2, doctor);
	}

	
	
	// 1. Appointment Operations

	public static void AppointmentOperations() {
		while (true) {
			System.out.println(
					"Choose the option: \n 1. Create new Appointment \n 2. Get Appointment using patient Id \n "
							+ "3. Get All Appointments \n "
							+ "4. Get Appointments By Doctor \n 5.Update the Appointment \n "
							+ "6. Delete the Appointment \n 7. Go back to main menu");

			int input = scanner.nextInt();

			switch (input) {
			case 1:
				Appointment appointment = appointmentInputs();
				boolean savedEntity = appointmentService.saveAppointment(appointment);
				System.out.println("Appointment details saved successfully. " + savedEntity);
				break;
			case 2:
				System.out.println("Enter the patient id you want : ");
				int id = scanner.nextInt();
				List<Appointment> appointments = appointmentService.getAppointmentsByPatientId(id);
				 System.out.println("Appointment using patient id is :" + appointments);
				break;
			case 3:
				List<Appointment> appointments2 = appointmentService.getAllAppointments();
				for (Appointment app : appointments2) {
					System.out.println(app);
				}
				break;
			case 4:
				System.out.println("Enter the doctor id you want : ");
				int id1 = scanner.nextInt();
				List<Appointment> appointments3 = appointmentService.getAppointmentsByDoctor(id1);
				System.out.println("Appointment using doctor id is : "+appointments3);
				break;
			case 5:
				System.out.println("Enter the id you want to update : ");
				int updated_appoint_id = scanner.nextInt();

				System.out.println("Enter the updated Appointment date: ");
				String updated_date = scanner.next();

				System.out.println("Enter the updated reason: ");
				String updated_reason = scanner.next();

				System.out.println("Enter the updated patient id: ");
				int updated_patient_id = scanner.nextInt();
				Patient patient_updated = patientService.getPatientById(updated_patient_id);

				System.out.println("Enter the updated doctor id: ");
				int updated_doctor_id = scanner.nextInt();
				Doctor updated_doctor = doctorService.findDoctorById(updated_doctor_id);

				appointmentService.updateAppointment(updated_appoint_id, updated_date, updated_reason, updated_doctor,
						patient_updated);
				System.out.println("Appointment details updated successfully.");

				break;

			case 6:
				System.out.println("Enter the id you want to delete: ");
				int delete_id = scanner.nextInt();
				boolean appointment3 = appointmentService.deleteAppointment(delete_id);
				break;

			case 7:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}
			default:
				System.out.println("Invalid option. Please choose again.");
			}

		}
	}

	// 2. Doctor
	public static void DoctorOperations() {
		while (true) {
			System.out.println(
					"Choose the option: \n 1. Add new Doctor details \n 2. Find the details of doctor using Id \n "
							+ "3. Get All Doctors list \n " + " 4.Update the Doctor \n "
							+ "5. Delete the Doctor \n 6. Go back to main menu");

			int input = scanner.nextInt();
			switch (input) {
			case 1:
				Doctor doctor = doctorInputs();
				boolean savedEntity = doctorService.saveDoctor(doctor);
				System.out.println("Doctor details saved successfully. " + savedEntity);
				break;
			case 2:
				System.out.println("Enter the doctor id you want : ");
				int id = scanner.nextInt();
				Doctor doctors = doctorService.findDoctorById(id);
				System.out.println("Doctor details with id : " + id + "is " + doctors);
				break;
			case 3:
				List<Doctor> doctors2 = doctorService.getAllDoctors();
				for (Doctor doc : doctors2) {
					System.out.println(doc);
				}
				break;
			case 4:
				System.out.println("Enter doctor ID:");
				int doctorId = scanner.nextInt();

				System.out.println("Enter new name:");
				scanner.nextLine();
				String name = scanner.nextLine();

				System.out.println("Enter the working hours :");
				String working_hours = scanner.next();

				System.out.println("Enter new specialization:");
				String specialization = scanner.nextLine();
				scanner.nextLine();

				System.out.println("Enter updated contact number : ");
				int contactNumber = scanner.nextInt();

				System.out.println("Enter updated Experience in years : ");
				int experienceYears = scanner.nextInt();
				
				

				doctorService.updateDoctorById(doctorId, name, working_hours, specialization, contactNumber,
						experienceYears);
				System.out.println("Doctor details updated successfully.");
				break;
				
				
			case 5:
				System.out.println("Enter doctor ID to delete:");
				int doctor_Id = scanner.nextInt();
				scanner.nextLine();
				doctorService.deleteDoctor(doctor_Id);
				System.out.println("Doctor with id : " + doctor_Id + "deleted successfully");
				break;
			case 6:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}
			default:
				System.out.println("Invalid option. Please choose again.");

			}
		}

	}

	// 3.operations
	public static void Operations() {
		System.out.println("Enter the patient type : (In patient (IP) / Out patient (OP)) :: ");
		String patient_type = scanner.nextLine().toLowerCase();

		if (patient_type.equals("inpatient".toLowerCase()) || patient_type.equals("ip".toLowerCase())) {
			InPatientOperations();
		} else if (patient_type.equals("outpatient".toLowerCase()) || patient_type.equals("op".toLowerCase())) {
			OutPatientOperations();
		} else {
			System.out.println("Enter correct type of patient");
		}
	}

	// 4. In patient operations

	public static void InPatientOperations() {
		while (true) {
			System.out
					.println("Choose the option: \n 1. Add new Patient Admission \n 2. Find Patient Admission by ID \n "
							+ "3. Get All Patient Admissions \n " + "4. Update Patient Admission \n "
							+ "5. Delete Patient Admission \n 6. Go back to main menu");

			int input = scanner.nextInt();
			switch (input) {
			case 1:
				Operations operations = operationsInputs();
				boolean savedEntity = operationsService.saveOperation(operations);
				System.out.println("Operation details saved successfully. " + savedEntity);
				break;
			case 2:
				System.out.println("Enter the admission id you want : ");
				int id = scanner.nextInt();
				Operations operations2 = operationsService.getOperationById(id);
				System.out.println("Patient with id "+id+"details are: "+operations2);
				break;
			case 3:
				List<Operations> operations3 = operationsService.getAllOperations();
				for (Operations ops : operations3) {
					System.out.println(ops);
				}
				break;
			case 4:
				System.out.println("Enter Admission ID:");
				int admissionId = scanner.nextInt();

				System.out.println("Enter new alloted room:");
				int room = scanner.nextInt();

				System.out.println("Enter Admission reason :");
				scanner.nextLine();
				String admission_reason = scanner.nextLine();

				System.out.println("Enter new Discharge date:");
				String discharge_date = scanner.nextLine();

				operationsService.updateOperation(admissionId, room, admission_reason, discharge_date);
				break;

			case 5:
				System.out.println("Enter the admission id which you want to delete : ");
				int inpatient_id = scanner.nextInt();
				scanner.nextLine();
				operationsService.deleteOperation(inpatient_id);
				System.out.println("In patient with id : " + inpatient_id + "is deleted successfully");

				break;

			case 6:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}
			default:
				System.out.println("Invalid option. Please choose again.");

			}

		}
	}

	// 4. out patient
	public static void OutPatientOperations() {
		while (true) {
			System.out.println("Choose the option: \n 1. Add new Patient Details \n 2. Find Patient by Patient ID \n "
					+ "3. Get All Patient details \n " + "4. Update Patient details \n "
					+ "5. Delete Patient details \n 6. Go back to main menu");

			int input = scanner.nextInt();
			switch (input) {
			case 1:
				Patient patient = patientInputs();
				boolean savedEntity = patientService.savePatient(patient);
				System.out.println("Patient details saved successfully.");
				break;

			case 2:
				System.out.println("Enter patient id you want: ");
				int id = scanner.nextInt();
				Patient patient2 = patientService.getPatientById(id);
				System.out.println("Patient details : " + patient2);
				break;

			case 3:
				List<Patient> patients = patientService.getAllPatients();
				for (Patient pats : patients) {
					System.out.println(pats);
				}
				break;

			case 4:
				System.out.println("Enter patient id : ");
				int patient_id = scanner.nextInt();

				System.out.println("Enter patient name : ");
				scanner.nextLine();
				String name = scanner.nextLine();

				System.out.println("Enter the gender : ");
				String gender = scanner.nextLine();

				System.out.println("Enter patients age : ");
				int age = scanner.nextInt();

				System.out.println("Enter contact number (numbers only ): ");
				int contact_no = scanner.nextInt();

				patientService.updatePatient(patient_id, name, gender, age, contact_no);
				break;

			case 5:
				System.out.println("Enter the patient id you want to delete: ");
				int outpatient_id = scanner.nextInt();
				scanner.nextLine();
				patientService.deletePatient(outpatient_id);

				System.out.println("Out patient id : " + outpatient_id + "deleted successfully");

				break;
			case 6:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}
			default:
				System.out.println("Invalid option. Please choose again.");

			}
		}
	}

	// 5. Test
	public static void TestOperations() {
		while (true) {
			System.out.println("Choose the option: \n 1. Add new Test \n 2. Find Test by ID \n "
					+ "3. Get All Tests \n " + "4. Update Test \n " + "5. Delete Test \n 6. Go back to main menu");

			int input = scanner.nextInt();
			switch (input) {
			case 1:
				Test test = testInputs();
				boolean savedEntity = testService.saveTest(test);
				System.out.println("Test details saved successfully");
				break;
			case 2:
				System.out.println("Enter test id you want: ");
				int id = scanner.nextInt();
				Test test2 = testService.getTestById(id);
				System.out.println("Test details with id : "+id+ "is " + test2);
				break;

			case 3:
				List<Test> tests = testService.getAllTests();
				for (Test test3 : tests) {
					System.out.println(test3);
				}
				break;
			case 4:
				System.out.println("Enter test id : ");
				int test_id = scanner.nextInt();

				System.out.println("Enter test name : ");
				scanner.nextLine();
				String name = scanner.nextLine();

				System.out.println("Enter test results : ");
				String result = scanner.nextLine();

				testService.updateTest(test_id, name, result);
				break;

			case 5:
				System.out.println("Enter the test id you want to delete: ");
				int test_id1 = scanner.nextInt();
				testService.deleteTest(test_id1);

				System.out.println("Test id with " + test_id1 + "is deleted successfully");
				break;

			case 6:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}
			default:
				System.out.println("Invalid option. Please choose again.");

			}
		}
	}

}

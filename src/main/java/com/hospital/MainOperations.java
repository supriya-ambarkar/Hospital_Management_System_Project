package com.hospital;

import java.util.Scanner;
import com.hospital.AllOperations;

public class MainOperations {

	static Scanner scanner = new Scanner(System.in);

	public static void mainOps() {
		while (true) {
			System.out.println("Welcome to Hospital Management System:\n " + "***********************************\n"
					+ "1.Appointment Details\n" + " 2.Doctor Details\n " + "3.Patient Details \n"
					+ " 4.Test Details \n 5. Exit\n Enter your choice");

			int input = scanner.nextInt();

			switch (input) {
			case 1:
				AllOperations.AppointmentOperations();
				System.out.println("******************");
				break;

			case 2:
				AllOperations.DoctorOperations();
				System.out.println("******************");
				break;

			case 3:
				AllOperations.Operations();
				System.out.println("******************");
				break;

			case 4:
				AllOperations.TestOperations();
				System.out.println("******************");
				break;

			case 5:
				System.exit(0);
			default:
				System.out.println("Entered wrong choice. Please choose correct choice...");
			}

		}
	}

	public static void main(String args[]) {
		mainOps();

	}
}

package com.tcfmissioncontrol.TCFMissionControl;
import java.util.Scanner;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	int choice;
    	
    	do {

    	    System.out.println("==============================");
    	    System.out.println("      TCF MISSION CONTROL");
    	    System.out.println("==============================");
    	    System.out.println("1. Manage Study Sessions");
    	    System.out.println("2. Record Practice Score");
    	    System.out.println("3. View Progress Report");
    	    System.out.println("4. Exit");

    	    System.out.print("Enter your choice: ");
    	    choice = scanner.nextInt();
    	    switch (choice) {
    	    case 1:
    	        System.out.println("Study Session Management selected.");
    	        break;

    	    case 2:
    	        System.out.println("Practice Score Tracking selected.");
    	        break;

    	    case 3:
    	        System.out.println("Progress Report selected.");
    	        break;

    	    case 4:
    	        System.out.println("Exiting TCF Mission Control...");
    	        break;

    	    default:
    	        System.out.println("Invalid choice. Please select an option from 1 to 4.");
    	}

    	} while (choice != 4);
    	scanner.close();

    	System.out.println("You selected: " + choice);
    }
}

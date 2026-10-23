package com.tcfmissioncontrol.TCFMissionControl;
import java.util.Scanner;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
    	StudyService studyService = new StudyService();
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

    	    case 1: {
    	        manageStudySessions(scanner, studyService);
    	    }

    	    case 2: {
    	    	System.out.print("case 2");
    	        break;
    	    }

    	    case 3: {
    	        System.out.print("case 3 ");
    	        

    	        break;
    	    }

    	    case 4: {
    	        System.out.println("Exiting TCF Mission Control...");
    	        break;
    	    }

    	    default: {
    	        System.out.println(
    	                "Invalid choice. Please select an option from 1 to 4."
    	        );
    	    }
    	}

    	} while (choice != 4);
    	scanner.close();

    	System.out.println("You selected: " + choice);
    	
    	
    }
    
    private static void manageStudySessions(
            Scanner scanner,
            StudyService studyService
    ) {
        int studyChoice;

        do {
            System.out.println("\nSTUDY SESSION MANAGEMENT");
            System.out.println("1. Add Study Session");
            System.out.println("2. View Study Sessions");
            System.out.println("3. Update Study Session");
            System.out.println("4. Delete Study Session");
            System.out.println("5. Return to Main Menu");

            System.out.print("Enter your choice: ");
            studyChoice = scanner.nextInt();
            scanner.nextLine();

            switch (studyChoice) {

                case 1: {
                	addStudySession(scanner, studyService);
                    break;
                }

                case 2: {
                    studyService.viewSessions();
                    break;
                }

                case 3: {
                	updateStudySession(scanner, studyService);
                    break;
                }

                case 4: {
                	deleteStudySession(scanner, studyService);
                    break;
                }

                case 5: {
                    System.out.println("Returning to main menu...");
                    break;
                }

                default: {
                    System.out.println(
                            "Invalid choice. Please select an option from 1 to 5."
                    );
                }
            }

        } while (studyChoice != 5);
    }
    
    private static void addStudySession(
            Scanner scanner,
            StudyService studyService
    ) {
        System.out.print("Enter session ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter skill: ");
        String skill = scanner.nextLine();

        System.out.print("Enter date: ");
        String date = scanner.nextLine();

        System.out.print("Enter duration in minutes: ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter notes: ");
        String notes = scanner.nextLine();

        StudySession session = new StudySession(
                id,
                skill,
                date,
                duration,
                notes
        );

        studyService.addSession(session);

        System.out.println("Study session added successfully.");
    }
    
    private static void updateStudySession(
            Scanner scanner,
            StudyService studyService
    ) {
        System.out.print("Enter session ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new skill: ");
        String skill = scanner.nextLine();

        System.out.print("Enter new date: ");
        String date = scanner.nextLine();

        System.out.print("Enter new duration in minutes: ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new notes: ");
        String notes = scanner.nextLine();

        boolean updated = studyService.updateSession(
                id,
                skill,
                date,
                duration,
                notes
        );

        if (updated) {
            System.out.println("Study session updated successfully.");
        } else {
            System.out.println("Study session not found.");
        }
    }
    
    private static void deleteStudySession(
            Scanner scanner,
            StudyService studyService
    ) {
        System.out.print("Enter session ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean deleted = studyService.deleteSession(id);

        if (deleted) {
            System.out.println("Study session deleted successfully.");
        } else {
            System.out.println("Study session not found.");
        }
    }
}



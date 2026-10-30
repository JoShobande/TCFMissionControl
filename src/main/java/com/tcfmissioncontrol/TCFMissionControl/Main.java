package com.tcfmissioncontrol.TCFMissionControl;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
    	StudyService studyService = new StudyService();
    	ScoreService scoreService = new ScoreService();
    	ProgressService progressService = new ProgressService(studyService, scoreService);
    	Scanner scanner = new Scanner(System.in);
    	int choice;
    	
    	do {

    	    System.out.println("==============================");
    	    System.out.println("      TCF MISSION CONTROL");
    	    System.out.println("==============================");
    	    System.out.println("1. Manage Study Sessions");
    	    System.out.println("2. Manage Practice");
    	    System.out.println("3. View Progress Report");
    	    System.out.println("4. Exit");

    	    choice = InputValidator.readIntInRange(
    	            scanner,
    	            "Enter your choice: ",
    	            1,
    	            4
    	    ); 
    	    switch (choice) {

    	    case 1: {
    	        manageStudySessions(scanner, studyService);
    	    }

    	    case 2: {
    	    	managePracticeScores(scanner, scoreService);
    	        break;
    	    }

    	    case 3: {
    	    	progressService.viewProgressReport();
    	        break;
    	    }

    	    case 4: {
    	        System.out.println("Exiting TCF Mission Control...");
    	        break;
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
            studyChoice = InputValidator.readIntInRange(
                    scanner,
                    "Enter your choice: ",
                    1,
                    5
            );

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
            }

        } while (studyChoice != 5);
    }
    
    private static void addStudySession(
            Scanner scanner,
            StudyService studyService
    ) {
    	System.out.println("Select skill:");
    	System.out.println("1. Reading");
    	System.out.println("2. Listening");
    	System.out.println("3. Speaking");
    	System.out.println("4. Writing");

    	int skillChoice = InputValidator.readIntInRange(
    	        scanner,
    	        "Enter your choice: ",
    	        1,
    	        4
    	);
    	
    	int id;

    	while (true) {

    	    id = InputValidator.readInt(
    	            scanner,
    	            "Enter session ID (or 0 to return): "
    	    );

    	    if (id == 0) {
    	        return;
    	    }

    	    if (id < 0) {
    	        System.out.println(
    	                "Session ID must be greater than 0."
    	        );
    	        continue;
    	    }

    	    try {
    	        studyService.validateUniqueSessionId(id);
    	        break;

    	    } catch (DuplicateSessionIdException e) {
    	        System.out.println(e.getMessage());
    	    }
    	}
  
    	String date = InputValidator.readValidDate(
    	        scanner,
    	        "Enter date (YYYY-MM-DD): "
    	);

    	int duration = InputValidator.readDuration(
    	        scanner,
    	        "Enter duration in minutes: "
    	);

    	String notes = InputValidator.readNotes(
    	        scanner,
    	        "Enter notes: "
    	);

        StudySession session;

        switch (skillChoice) {
            case 1:
                session = new ReadingSession(id, date, duration, notes);
                break;

            case 2:
                session = new ListeningSession(id, date, duration, notes);
                break;

            case 3:
                session = new SpeakingSession(id, date, duration, notes);
                break;

            case 4:
                session = new WritingSession(id, date, duration, notes);
                break;
            default:
                return;
        }
        try {

            studyService.addSession(session);

            System.out.println(
                    "Study session added successfully."
            );

        } catch (DuplicateSessionIdException e) {

            System.out.println(e.getMessage());
        }

    }
    
    private static void updateStudySession(
            Scanner scanner,
            StudyService studyService
    ) {

        int id = InputValidator.readPositiveInt(
                scanner,
                "Enter session ID to update: "
        );

        StudySession session = studyService.findSessionById(id);

        if (session == null) {
            System.out.println("Session not found.");
            return;
        }

        System.out.println("\nWhat would you like to update?");
        System.out.println("1. Date");
        System.out.println("2. Duration");
        System.out.println("3. Notes");
        System.out.println("4. Return");

        int choice = InputValidator.readIntInRange(
                scanner,
                "Enter your choice: ",
                1,
                4
        );

        switch (choice) {

            case 1:
                String newDate = InputValidator.readValidDate(
                        scanner,
                        "Enter new date (YYYY-MM-DD): "
                );

                session.setDate(newDate);
                System.out.println("Date updated successfully.");
                break;

            case 2:
                int newDuration = InputValidator.readDuration(
                        scanner,
                        "Enter new duration in minutes: "
                );

                session.setDuration(newDuration);
                System.out.println("Duration updated successfully.");
                break;

            case 3:
                String newNotes = InputValidator.readNotes(
                        scanner,
                        "Enter new notes: "
                );

                session.setNotes(newNotes);
                System.out.println("Notes updated successfully.");
                break;

            case 4:
                return;
        }
    }
    
    private static void deleteStudySession(
            Scanner scanner,
            StudyService studyService
    ) {
	   int id = InputValidator.readPositiveInt(
               scanner,
               "Enter session ID to delete: "
       );


        boolean deleted = studyService.deleteSession(id);

        if (deleted) {
            System.out.println("Study session deleted successfully.");
        } else {
            System.out.println("Study session not found.");
        }
    }
    
//    Feature 2: REcord and view practice scores
    
    private static void managePracticeScores(
            Scanner scanner,
            ScoreService scoreService
    ) {
        int choice;

        do {
            System.out.println("\nPRACTICE SCORE TRACKING");
            System.out.println("1. Record Practice Score");
            System.out.println("2. View Practice Scores");
            System.out.println("3. Return to Main Menu");

            choice = InputValidator.readIntInRange(
                    scanner,
                    "Enter your choice: ",
                    1,
                    3
            );

            switch (choice) {
                case 1: {
                    recordPracticeScore(scanner, scoreService);
                    break;
                }

                case 2: {
                    scoreService.viewScores();
                    break;
                }

                case 3: {
                    System.out.println("Returning to main menu...");
                    break;
                }

            }

        } while (choice != 3);
    }
    
    private static void recordPracticeScore(
            Scanner scanner,
            ScoreService scoreService
    ) {
        System.out.println("\nPRACTICE SCORE TRACKING");
        System.out.println("1. Reading");
        System.out.println("2. Listening");
        System.out.println("3. Speaking");
        System.out.println("4. Writing");

        int skillChoice = InputValidator.readIntInRange(
                scanner,
                "Enter your choice: ",
                1,
                4
        );

        String skill;

        switch (skillChoice) {
            case 1:
                skill = "Reading";
                break;

            case 2:
                skill = "Listening";
                break;

            case 3:
                skill = "Speaking";
                break;

            case 4:
                skill = "Writing";
                break;

            default:
                throw new IllegalStateException(
                        "Unexpected skill choice: " + skillChoice
                );
        }

        int score = InputValidator.readScore(
                scanner,
                "Enter score: "
        );

//        PracticeScore practiceScore = new PracticeScore(skill, score);

        scoreService.addScore(skill, score);

        System.out.println("Practice score recorded successfully.");
    }
}





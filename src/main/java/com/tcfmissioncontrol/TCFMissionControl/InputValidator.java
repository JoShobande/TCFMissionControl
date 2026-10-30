package com.tcfmissioncontrol.TCFMissionControl;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class InputValidator {

    public static int readInt(Scanner scanner, String prompt) {

        while (true) {
            System.out.print(prompt);

            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid input. Please enter a whole number."
                );
            }
        }
    }
    public static int readIntInRange(
            Scanner scanner,
            String prompt,
            int min,
            int max
    ) {

        while (true) {
            int value = readInt(scanner, prompt);

            if (value >= min && value <= max) {
                return value;
            }

            System.out.println(
                "Invalid choice. Please enter a number between "
                + min + " and " + max + "."
            );
        }
    }
    
    public static int readPositiveInt(
            Scanner scanner,
            String prompt
    ) {

        while (true) {

            int value = readInt(scanner, prompt);

            if (value > 0) {
                return value;
            }

            System.out.println(
                "Invalid input. Please enter a number greater than 0."
            );
        }
    }
    
    public static String readValidDate(
            Scanner scanner,
            String prompt
    ) {

        while (true) {

            System.out.print(prompt);
            String input = scanner.nextLine();

            try {
                LocalDate date = LocalDate.parse(input);

                if (date.isAfter(LocalDate.now())) {
                    System.out.println(
                        "Invalid date. Study session date cannot be in the future."
                    );
                    continue;
                }

                return input;

            } catch (DateTimeParseException e) {
                System.out.println(
                    "Invalid date. Please use the format YYYY-MM-DD."
                );
            }
        }
    }
    
    public static int readDuration(
            Scanner scanner,
            String prompt
    ) {

        while (true) {

            int duration = readInt(scanner, prompt);

            if (duration > 0 && duration <= 600) {
                return duration;
            }

            System.out.println(
                "Invalid duration. Please enter a value between 1 and 600 minutes."
            );
        }
    }
    
    public static String readNotes(
            Scanner scanner,
            String prompt
    ) {

        while (true) {

            System.out.print(prompt);
            String notes = scanner.nextLine().trim();

            if (!notes.isEmpty()) {
                return notes;
            }

            System.out.println(
                "Notes cannot be empty. Please enter some notes."
            );
        }
    }
    
    public static int readScore(
            Scanner scanner,
            String prompt
    ) {

        while (true) {

            int score = readInt(scanner, prompt);

            if (score >= 0 && score <= 100) {
                return score;
            }

            System.out.println(
                    "Invalid score. Please enter a value between 0 and 100."
            );
        }
    }
}

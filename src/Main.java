//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*
 * =========================================================
 * Neon Ark Admin Console
 * =========================================================
 * Course: COSC 4301
 * Professor: Jon-Mikel Pearson
 * Author: Sara Elbahri
 *
 * Description:
 * This Java console application simulates a client-side
 * admin console used to manage Warden records for the
 * Neon Ark system.
 *
 * The application demonstrates:
 * - CSV data handling
 * - Input validation
 * - Simulated REST API requests
 * - JSON payload creation
 * - Menu-driven console interaction
 *
 * Features:
 * 1. Add New Warden
 * 2. View All Wardens from CSV
 * 3. Update Existing Warden
 * 4. Manage Certifications
 * 5. Deactivate / Terminate Warden
 * 6. Exit Menu
 *
 * Notes:
 * - wardens.csv acts as a simulated database
 * - API calls are simulated only
 * - No real backend or database is connected
 * =========================================================
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            // =========================
            // DISPLAY MAIN MENU
            // =========================

            System.out.println("\n========================================");
            System.out.println("NEON ARK — ADMIN CONSOLE");
            System.out.println("========================================");
            System.out.println("Select from the following Menu");
            System.out.println("1. Add New Warden");
            System.out.println("2. View Wardens");
            System.out.println("3. Update Warden");
            System.out.println("4. Manage Certifications");
            System.out.println("5. Deactivate / Terminate Warden");
            System.out.println("6. Exit the Menu");
            System.out.print("Choose an option from the Menu (1-6): ");
            choice = scanner.nextInt();

            //2.get input

            // 3/ switch between options
            switch (choice) {
                case 1: // CASE 1 - ADD NEW WARDEN
                    // Collect Warden information
                    scanner.nextLine();
                    String firstName;
                    String lastName;
                    String email;
                    String startDate = "";
                    String endDate = "";
                    int roleId;
                    int statusId;
                    int clearanceId;
                    // Validate names, email, IDs, and dates
                    System.out.println("\n--- Add New Warden ---");
                    System.out.print("Enter Warden's First Name: ");
                    firstName = scanner.nextLine();
                    while (firstName.trim().isEmpty()) {
                        System.out.print("First Name of the Warden can't be empty.Please try again: ");
                        firstName = scanner.nextLine();
                    }
                    while (!firstName.trim().matches("[a-zA-Z]+")) {
                        System.out.print("Invalid First Name for Warden. Use letters only: ");
                        firstName = scanner.nextLine();

                    }
                    System.out.print("Enter Warden's Last Name: ");
                    lastName = scanner.nextLine();
                    while (lastName.trim().isEmpty()) {
                        System.out.print("Last Name of the Warden can't be empty. Please try again: ");
                        lastName = scanner.nextLine();
                    }
                    while (!lastName.trim().matches("[a-zA-Z]+")) {
                        System.out.print("Invalid Last Name for Warden. Use letters only: ");
                        lastName = scanner.nextLine();

                    }


                    System.out.print("Enter Email: ");
                    email = scanner.nextLine();
                    while (email.trim().isEmpty()) {
                        System.out.print("Email can't be empty, please try again: ");
                        email = scanner.nextLine();
                    }
                    while (!email.contains("@") || !email.contains(".")) {
                        System.out.print("Invalid email format, email must contain @ and . : ");
                        email = scanner.nextLine();
                    }

                    System.out.print("Enter Role ID: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Invalid Role Id, please enter a number: ");
                        scanner.nextLine();
                    }
                    roleId = scanner.nextInt();
                    while (roleId < 1 || roleId > 5) {
                        System.out.print("\nInvalid number, please enter a number between 1 and 5: ");


                        while (!scanner.hasNextInt()) {
                            System.out.print("Invalid Role Id, please enter a number: ");
                            scanner.nextLine();
                        }
                        roleId = scanner.nextInt();
                    }

                    System.out.print("Enter Status ID: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Invalid Status ID, please enter a number: ");
                        scanner.nextLine();
                    }
                    statusId = scanner.nextInt();

                    while (statusId < 1 || statusId > 5) {
                        System.out.print("Invalid Status ID , please enter a number between 1 and 5: ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("Invalid Status ID, please enter a number: ");
                            scanner.nextLine();
                        }
                        statusId = scanner.nextInt();

                    }
                    scanner.nextLine();
                    boolean validStartDate = false;
                    while (!validStartDate) {
                        System.out.print("Enter Start Date (YYYY-MM-DD): ");
                        startDate = scanner.nextLine();
                        try {
                            LocalDate.parse(startDate);
                            validStartDate = true;

                        } catch (DateTimeParseException e) {
                            System.out.print("Invalid start date.Please enter a real date in YYYY-MM-DD format.\n");
                        }
                    }

                    boolean validEndDate = false;
                    while (!validEndDate) {
                        System.out.print("Enter End Date (YYYY-MM-DD or leave blank): ");
                        endDate = scanner.nextLine();
                        if (endDate.trim().isEmpty()) {
                            validEndDate = true;
                        } else {
                            try {
                                LocalDate parseStartDate = LocalDate.parse(startDate);
                                LocalDate parseEndDate = LocalDate.parse(endDate);
                                if (parseEndDate.isBefore(parseStartDate)) {
                                    System.out.print("End date must be after start date, try again.");
                                } else {
                                    validEndDate = true;
                                }

                            } catch (DateTimeParseException e) {
                                System.out.print("Invalid end date. Please enter a real date in YYYY-MM-DD format.");
                            }
                        }
                    }

                    System.out.print("Enter Clearance ID: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Invalid Clearance ID, please provide a number: ");
                        scanner.nextLine();
                    }
                    clearanceId = scanner.nextInt();
                    while (clearanceId < 1 || clearanceId > 3) {
                        System.out.print("Invalid number, please provide a number between 1 and 3: ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("Invalid Clearance ID, please provide a number: ");
                            scanner.nextLine();
                        }
                        clearanceId = scanner.nextInt();
                    }
                    // Simulate POST API request
                    System.out.println("\nWarden entered successfully (simulation).");
                    System.out.println("\nWOULD SEND: POST /api/wardens");
                    System.out.println("BRIEF DESCRIPTION: Create a new Warden record.");
                    System.out.println("PAYLOAD (JSON):");

                    System.out.println("{");
                    System.out.println("  \"firstName\":  \"" + firstName + "\", ");
                    System.out.println("  \"lastName\": \"" + lastName + "\",");
                    System.out.println("  \"email\": \"" + email + "\",");
                    System.out.println("  \"roleId\": " + roleId + ",");
                    System.out.println("  \"statusId\": " + statusId + ",");
                    System.out.println("  \"startDate\": \"" + startDate + "\",");

                    if (endDate.trim().isEmpty()) {
                        System.out.println(" \"endDate\": null,");
                    } else {
                        System.out.println(" \"endDate\": \"" + endDate + "\", ");
                    }
                    System.out.println("  \"clearanceId\": " + clearanceId);
                    System.out.print("}");
                    System.out.println("\n RESULT: SUCCESS (simulated)");

                    break;

                case 2:
                    // Open CSV file for reading

                    // Skip CSV header row

                    // Read each Warden record from CSV

                    // Split CSV line into fields

                    // Replace empty end date with NULL

                    // Display Warden information
                    System.out.println("\n--- View Wardens ---");
                    System.out.println("------------------------------------------------------------");
                    System.out.println("ID | First Name | Last Name | Email | Role | Status | Start Date | End Date | Clearance");
                    try {
                        File file = new File("wardens.csv"); // Open wardens.csv file in read-only mode
                        Scanner fileScanner = new Scanner(file);
                        fileScanner.nextLine();
                        // Read each Warden record line-by-line from the CSV file

                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            String[] data = line.split(",");
                            // Split CSV data into individual fields using commas

                            String csvWardenId = data[0];
                            String csvFirstName = data[1];
                            String csvLastName = data[2];
                            String csvEmail = data[3];
                            String csvRoleId = data[4];
                            String csvStatusId = data[5];
                            String csvStartDate = data[6];
                            String csvEndDate = data[7];
                            String csvClearanceId = data[8];
                            // Replace blank end dates with NULL for cleaner display
                            if (csvEndDate.isEmpty()) {
                                csvEndDate = "NULL";
                            }
                            System.out.println(
                                    csvWardenId + " | " +
                                            csvFirstName + " | " +
                                            csvLastName + " | " +
                                            csvEmail + " | " +
                                            csvRoleId + " | " +
                                            csvStatusId + " | " +
                                            csvStartDate + " | " +
                                            csvEndDate + " | " +
                                            csvClearanceId
                            );

                        }
                        // Close file scanner after reading all records
                        fileScanner.close();

                    } catch (FileNotFoundException e) {
                        System.out.println("Error: CSV file not found.");
                    }
                    break;
                case 3:
                    String field = "";
                    String newValue = "";
                    int wardenIdToUpdate;

                    System.out.println("\n---- Update Warden ----");

                    System.out.print("Enter Warden ID to update: "); // Collect and validate the Warden ID to update
                    while (!scanner.hasNextInt()) {
                        System.out.print("Invalid Warden ID. Please enter a number: ");
                        scanner.nextLine();
                    }

                    wardenIdToUpdate = scanner.nextInt();
                    scanner.nextLine();

                    while (wardenIdToUpdate < 1 || wardenIdToUpdate > 20) {
                        System.out.print("Invalid Warden ID. Enter a number between 1 and 20: ");

                        while (!scanner.hasNextInt()) {
                            System.out.print("Invalid Warden ID. Please enter a number: ");
                            scanner.nextLine();
                        }

                        wardenIdToUpdate = scanner.nextInt();
                        scanner.nextLine();
                    }

                    boolean validField = false;

                    while (!validField) {
                        System.out.print("Enter Warden field to update: ");
                        field = scanner.nextLine();

                        if (field.equalsIgnoreCase("firstName")) {
                            field = "firstName";
                            validField = true;
                        } else if (field.equalsIgnoreCase("lastName")) {
                            field = "lastName";
                            validField = true;
                        } else if (field.equalsIgnoreCase("email")) {
                            field = "email";
                            validField = true;
                        } else if (field.equalsIgnoreCase("roleId")) {
                            field = "roleId";
                            validField = true;
                        } else if (field.equalsIgnoreCase("statusId")) {
                            field = "statusId";
                            validField = true;
                        } else if (field.equalsIgnoreCase("startDate")) {
                            field = "startDate";
                            validField = true;
                        } else if (field.equalsIgnoreCase("endDate")) {
                            field = "endDate";
                            validField = true;
                        } else if (field.equalsIgnoreCase("clearanceId")) {
                            field = "clearanceId";
                            validField = true;
                        } else {
                            System.out.println("Error: Invalid Field");
                            System.out.println("Valid Fields:");
                            System.out.println("firstName, lastName, email, roleId, statusId, startDate, endDate, clearanceId");
                        }
                    }

                    System.out.print("Enter new value: ");
                    newValue = scanner.nextLine();

                    if (field.equals("firstName") || field.equals("lastName")) {
                        while (!newValue.trim().matches("[a-zA-Z]+")) {
                            System.out.print("Invalid name. Use letters only: ");
                            newValue = scanner.nextLine();
                        }
                    }

                    if (field.equals("email")) {
                        while (!newValue.contains("@") || !newValue.contains(".")) {
                            System.out.print("Invalid email format. Enter again: ");
                            newValue = scanner.nextLine();
                        }
                    }

                    if (field.equals("roleId")) {
                        while (!newValue.matches("[1-5]")) {
                            System.out.print("Invalid Role ID. Enter a number between 1 and 5: ");
                            newValue = scanner.nextLine();
                        }
                    }

                    if (field.equals("statusId")) {
                        while (!newValue.matches("[1-5]")) {
                            System.out.print("Invalid Status ID. Enter a number between 1 and 5: ");
                            newValue = scanner.nextLine();
                        }
                    }

                    if (field.equals("clearanceId")) {
                        while (!newValue.matches("[1-3]")) {
                            System.out.print("Invalid Clearance ID. Enter a number between 1 and 3: ");
                            newValue = scanner.nextLine();
                        }
                    }

                    if (field.equals("startDate") || field.equals("endDate")) {
                        boolean validDate = false;

                        while (!validDate) {
                            try {
                                LocalDate.parse(newValue);
                                validDate = true;
                            } catch (DateTimeParseException e) {
                                System.out.print("Invalid date. Use YYYY-MM-DD: ");
                                newValue = scanner.nextLine();
                            }
                        }
                    }

                   // Display simulated PUT API request with updated JSON payload
                    System.out.println("\nWOULD SEND: PUT /api/wardens/" + wardenIdToUpdate);
                    System.out.println("BRIEF DESCRIPTION: Update an existing Warden record.");
                    System.out.println("PAYLOAD (JSON):");
                    System.out.println("{");
                    System.out.println("  \"" + field + "\": \"" + newValue + "\"");
                    System.out.println("}");
                    System.out.println("RESULT: SUCCESS (simulated)");

                    break;
                case 4:
                    int certificationWardenId;
                    String certificationName;
                    String earnedDate = "";
                    String expirationDate = "";
                    System.out.println("Manage Certifications selected");
                    System.out.print("Enter Warden ID: ");// Collect and validate the Warden ID for certification assignment

                    while (!scanner.hasNextInt()) {
                        System.out.print("Invalid Warden ID. Please enter a number: ");
                        scanner.nextLine();
                    }

                    certificationWardenId = scanner.nextInt();
                    scanner.nextLine();

                    while(certificationWardenId < 1 || certificationWardenId > 20) {

                        System.out.print("Invalid Warden ID. Enter a number between 1 and 20: ");

                        while (!scanner.hasNextInt()) {
                            System.out.print("Invalid Warden ID. Please enter a number: ");
                            scanner.nextLine();
                        }

                        certificationWardenId = scanner.nextInt();
                        scanner.nextLine();
                    }
                    System.out.print("Enter Certification Name: "); // Collect certification name and ensure it is not empty
                    certificationName = scanner.nextLine();

                    while (certificationName.trim().isEmpty()) {
                        System.out.print("Certification name cannot be empty: ");
                        certificationName = scanner.nextLine();
                    }
                    boolean validEarnedDate = false;

                    while (!validEarnedDate) {

                        System.out.print("Enter Earned Date (YYYY-MM-DD): "); // Validate earned date using YYYY-MM-DD format
                        earnedDate = scanner.nextLine();

                        try {
                            LocalDate.parse(earnedDate);
                            validEarnedDate = true;

                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date. Use YYYY-MM-DD.");
                        }
                    }
                    boolean validExpirationDate = false;

                    while (!validExpirationDate) {

                        System.out.print("Enter Expiration Date (YYYY-MM-DD): ");// Validate expiration date using YYYY-MM-DD format
                        expirationDate = scanner.nextLine();

                        try {

                            LocalDate earned = LocalDate.parse(earnedDate);
                            LocalDate expiration = LocalDate.parse(expirationDate);
                            // Ensure expiration date occurs after earned date
                            if (expiration.isAfter(earned)) {
                                validExpirationDate = true;
                            } else {
                                System.out.println("Expiration date must be after earned date.");
                            }

                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date. Use YYYY-MM-DD.");
                        }
                    } // Display simulated POST API request for certification creation
                    System.out.println("\nWOULD SEND: POST /api/wardens/" + certificationWardenId + "/certifications");
                    System.out.println("BRIEF DESCRIPTION: Create a new certification record and associate it with an existing Warden.");
                    System.out.println("PAYLOAD (JSON):");
                    System.out.println("{");
                    System.out.println("  \"name\": \"" + certificationName + "\",");
                    System.out.println("  \"earnedDate\": \"" + earnedDate + "\",");
                    System.out.println("  \"expirationDate\": \"" + expirationDate + "\"");
                    System.out.println("}");
                    System.out.println("RESULT: SUCCESS (simulated)");
                    break;
                case 5:
                    int deactivateWardenId;
                    String reason;
                    String effectiveDate = "";

                    System.out.println("\n--- Deactivate / Terminate Warden ---");

                    System.out.println("Deactivate Warden selected");
                    System.out.print("Enter Warden ID to update: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Invalid Warden ID. Please enter a number: ");
                        scanner.nextLine();
                    }
                    // Collect reason for deactivation or termination

                    deactivateWardenId = scanner.nextInt();
                    scanner.nextLine();
                    while (deactivateWardenId < 1 ||deactivateWardenId > 20) {
                        System.out.print("Invalid Warden ID. Enter a number between 1 and 20: ");

                        while (!scanner.hasNextInt()) {
                            System.out.print("Invalid Warden ID. Please enter a number: ");
                            scanner.nextLine();
                        }

                        deactivateWardenId = scanner.nextInt();
                        scanner.nextLine();
                    }
                    System.out.print("Enter reason for deactivation/termination: ");
                    reason = scanner.nextLine();

                    while(reason.trim().isEmpty()) {
                        System.out.print("Reason cannot be empty: ");
                        reason = scanner.nextLine();
                    }
                    boolean validEffectiveDate = false;

                    while (!validEffectiveDate) {

                        System.out.print("Enter Effective Date (YYYY-MM-DD): ");
                        effectiveDate = scanner.nextLine();

                        try {
                            LocalDate.parse(effectiveDate);
                            validEffectiveDate = true;

                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date. Use YYYY-MM-DD.");
                        }
                    }
                    // Display simulated PATCH API request for Warden status update
                    System.out.println("\nWOULD SEND: PATCH /api/wardens/" + deactivateWardenId + "/status");

                    System.out.println("BRIEF DESCRIPTION: Deactivate or terminate an existing Warden record.");

                    System.out.println("PAYLOAD (JSON):");
                    System.out.println("{");
                    System.out.println("  \"statusId\": 5,");
                    System.out.println("  \"reason\": \"" + reason + "\",");
                    System.out.println("  \"effectiveDate\": \"" + effectiveDate + "\"");
                    System.out.println("}");

                    System.out.println("RESULT: SUCCESS (simulated)");

                    break;
                case 6:
                    System.out.println("Exiting the Menu"); // Exit the Neon Ark Admin Console application
                    break;
                default:
                    System.out.println("Invalid choice, try again");
            }
        } while (choice != 6);
        scanner.close();
    }
}

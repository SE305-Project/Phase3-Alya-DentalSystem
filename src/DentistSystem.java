import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Class to represent a Patient
class Patient {
    private String cprNumber; // CPR number of the patient
    private String caseHistory; // Case history of the patient
    private String nextAppointmentDate; // Date of the next appointment

    // Constructor to initialize a Patient object
    public Patient(String cprNumber, String caseHistory, String nextAppointmentDate) {
        this.cprNumber = cprNumber;
        this.caseHistory = caseHistory;
        this.nextAppointmentDate = nextAppointmentDate;
    }

    // Getter method to retrieve the CPR number
    public String getCprNumber() {
        return cprNumber;
    }

    // Getter method to retrieve the case history
    public String getCaseHistory() {
        return caseHistory;
    }

    // Getter method to retrieve the next appointment date
    public String getNextAppointmentDate() {
        return nextAppointmentDate;
    }
}

// Main class to implement the Dentist System
public class DentistSystem {
    // HashMap to store patient records with CPR number as key
    private static HashMap<String, Patient> patientRecords = new HashMap<>();

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        // Main loop to display menu and handle user input
        while (isRunning) {
            System.out.println("1. Enter Patient Record");
            System.out.println("2. View Patient Record");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    enterPatientRecord(scanner);
                    break;
                case 2:
                    viewPatientRecord(scanner);
                    break;
                case 3:
                    isRunning = false; // Exit the loop and terminate the program
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }

        scanner.close();
    }

    // Method to enter a new patient record
    public static void enterPatientRecord(Scanner scanner) {
        System.out.print("Enter patient's CPR number: ");
        String cprNumber = scanner.next();
        System.out.print("Enter patient's case history: ");
        String caseHistory = scanner.next();
        System.out.print("Enter patient's next appointment date: ");
        String nextAppointmentDate = scanner.next();

        // Create a new Patient object and add it to the HashMap
        Patient patient = new Patient(cprNumber, caseHistory, nextAppointmentDate);
        patientRecords.put(cprNumber, patient);
        System.out.println("Patient record added successfully.");
    }

    // Method to view an existing patient record
    public static void viewPatientRecord(Scanner scanner) {
        System.out.print("Enter patient's CPR number: ");
        String cprNumber = scanner.next();

        // Check if the CPR number exists in the HashMap
        if (patientRecords.containsKey(cprNumber)) {
            // If found, retrieve the patient record and display it
            Patient patient = patientRecords.get(cprNumber);
            System.out.println("Patient's Case History: " + patient.getCaseHistory());
            System.out.println("Next Appointment Date: " + patient.getNextAppointmentDate());
        } else {
            // If not found, display a message
            System.out.println("Patient record not found.");
        }
    }

    public static <V, K> Map<K,V> getPatientRecords() {
        return (Map<K, V>) patientRecords;
    }
}

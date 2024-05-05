import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class DentistSystemTest {

    @Test
    public void testEnterPatientRecord() {
        // Arrange
        String input = "123456789 Toothache 2024-05-10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act
        DentistSystem.enterPatientRecord(new Scanner(System.in));

        // Assert
        assertTrue(outputStream.toString().contains("Patient record added successfully."));
    }

    @Test
    public void testViewPatientRecord() {
        // Arrange
        String cprNumber = "123456789";
        String caseHistory = "Toothache";
        String nextAppointmentDate = "2024-05-10";
        DentistSystem.getPatientRecords().put(cprNumber, new Patient(cprNumber, caseHistory, nextAppointmentDate));

        String input = "123456789";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act
        DentistSystem.viewPatientRecord(new Scanner(System.in));

        // Assert
        assertTrue(outputStream.toString().contains("Patient's Case History: " + caseHistory));
        assertTrue(outputStream.toString().contains("Next Appointment Date: " + nextAppointmentDate));
    }
}

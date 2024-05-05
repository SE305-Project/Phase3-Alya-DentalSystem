import org.junit.Test;

public class PatientTest {

    @Test
    public void testGetCprNumber() {
        // Arrange
        String cprNumber = "123456789";
        String caseHistory = "Toothache";
        String nextAppointmentDate = "2024-05-10";
        Patient patient = new Patient(cprNumber, caseHistory, nextAppointmentDate);

        // Act
        String patientCprNumber = patient.getCprNumber();

        // Assert
        assertEquals(cprNumber, patientCprNumber);
    }

    private void assertEquals(String cprNumber, String patientCprNumber) {
    }

    @Test
    public void testGetCaseHistory() {
        // Arrange
        String cprNumber = "123456789";
        String caseHistory = "Toothache";
        String nextAppointmentDate = "2024-05-10";
        Patient patient = new Patient(cprNumber, caseHistory, nextAppointmentDate);

        // Act
        String patientCaseHistory = patient.getCaseHistory();

        // Assert
        assertEquals(caseHistory, patientCaseHistory);
    }

    @Test
    public void testGetNextAppointmentDate() {
        // Arrange
        String cprNumber = "123456789";
        String caseHistory = "Toothache";
        String nextAppointmentDate = "2024-05-10";
        Patient patient = new Patient(cprNumber, caseHistory, nextAppointmentDate);

        // Act
        String patientNextAppointmentDate = patient.getNextAppointmentDate();

        // Assert
        assertEquals(nextAppointmentDate, patientNextAppointmentDate);
    }
}

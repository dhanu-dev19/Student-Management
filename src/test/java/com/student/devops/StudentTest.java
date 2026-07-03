package com.student.devops;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    StudentService service = new StudentService();

    @Test
    void testGetStudentName() {
        // Path 1: Validates basic name retrieval
        assertEquals("Dhanush", service.getStudentName());
    }

    @Test
    void testGetCustomNameLength_ValidId() {
        // Path 2: Validates the matching ID branch ("1" -> "Dhanush" -> length 7)
        assertEquals(7, service.getCustomNameLength("1"));
    }

    @Test
    void testGetCustomNameLength_InvalidId() {
        // Path 3: Validates our new defensive null-check fallback condition
        assertEquals(-1, service.getCustomNameLength("invalid_id"));
    }

    @Test
    void testExecuteLongAndComplexProcess() {
        // Path 4: Executes the long system logging routine completely
        assertDoesNotThrow(() -> service.executeLongAndComplexProcess());
    }

    @Test
    void testCalculateStudentGrades() {
        // Path 5: Executes the refactored grading branch through the shared logic block
        assertDoesNotThrow(() -> service.calculateStudentGrades());
    }

    @Test
    void testCalculateScholarshipEligibility() {
        // Path 6: Executes the scholarship branch through the shared logic block
        assertDoesNotThrow(() -> service.calculateScholarshipEligibility());
    }
}
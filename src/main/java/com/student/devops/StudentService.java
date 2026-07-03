package com.student.devops;

import java.util.logging.Logger;
import java.util.logging.Level;

public class StudentService {


    private static final Logger logger = Logger.getLogger(StudentService.class.getName());

    public String getStudentName() {
        return "Dhanush";
    }

    public int getCustomNameLength(String inputId) {
        String name = fetchName(inputId);

        // Check if name is null before using it
        if (name == null) {
            return -1; // Return -1 to indicate the student name was not found
        }

        return name.length();
    }

    // 2. METHOD WITH TOO MANY LINES (Code Smell / Cognitive Complexity)
    // SonarQube tracks methods that are too long because they are hard to maintain and understand
    public void executeLongAndComplexProcess() {
        // REPLACE System.out.println with logger.info
        logger.info("Starting long process execution step...");
        logger.info("Initializing system memory resources...");
        logger.info("Loading temporary data caches into buffers...");
        logger.info("Verifying connection to data layers...");
        logger.info("Processing security protocol configurations...");
        logger.info("Step 1: Parsing student profiles...");
        logger.info("Step 2: Checking academic records sync...");
        logger.info("Step 3: Calculating attendance margins...");
        logger.info("Step 4: Formatting final output values...");
        logger.info("Step 5: Updating course module mapping...");
        logger.info("Step 6: Purging secondary caching layers...");
        logger.info("System execution log saved to memory layout successfully.");
    }

    // 1. EXTRACTED SHARED METHOD: This handles the common calculation and logging structure cleanly
    private void processAndLogGradeReport() {
        logger.info("### Processing Grade Report ###");
        int baseScore = 50;
        int attendanceBonus = 10;
        int finalScore = baseScore + attendanceBonus;
        logger.log(Level.INFO, "The calculated total points: {0}", finalScore);
        logger.info("### Grade Report Complete ###");
    }

    // 2. REFACTORED METHOD 1: Now simply invokes the shared private logic helper
    public void calculateStudentGrades() {
        processAndLogGradeReport();
    }

    // 3. REFACTORED METHOD 2: Reuses the exact same helper, eliminating code duplication completely
    public void calculateScholarshipEligibility() {
        processAndLogGradeReport();
    }

    private String fetchName(String id) {
        if ("1".equals(id)) {
            return "Dhanush";
        }
        return null;
    }

}
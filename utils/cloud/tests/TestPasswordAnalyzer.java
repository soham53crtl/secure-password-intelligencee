package tests;

import analyzer.PasswordAnalyzer;

public class TestPasswordAnalyzer {

    public static void main(String[] args) {

        runTest("12345");
        runTest("Test123");
        runTest("Strong@123");
        runTest("");
        runTest(null);
    }

    static void runTest(String password) {
        try {
            int score = PasswordAnalyzer.calculateScore(password);
            String strength = PasswordAnalyzer.getStrength(score);

            System.out.println("Password: " + password);
            System.out.println("Score: " + score);
            System.out.println("Strength: " + strength);

        } catch (Exception e) {
            System.out.println("Handled error for input: " + password);
        }

        System.out.println("-----------------------");
    }
}

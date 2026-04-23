package analyzer;

public class PasswordAnalyzer {

    public static int calculateScore(String password) {

        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        int score = 0;

        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasLower = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");

        if (password.length() >= 8) score += 20;
        if (hasUpper) score += 20;
        if (hasLower) score += 20;
        if (hasDigit) score += 20;
        if (hasSpecial) score += 20;

        return score;
    }

    public static String getStrength(int score) {
        if (score >= 80) return "Strong";
        if (score >= 50) return "Medium";
        return "Weak";
    }

    // Entropy (advanced security)
    public static double calculateEntropy(String password) {
        int charset = 0;

        if (password.matches(".*[a-z].*")) charset += 26;
        if (password.matches(".*[A-Z].*")) charset += 26;
        if (password.matches(".*[0-9].*")) charset += 10;
        if (password.matches(".*[^a-zA-Z0-9].*")) charset += 32;

        return password.length() * (Math.log(charset) / Math.log(2));
    }
}

import analyzer.PasswordAnalyzer;
import utils.HashUtil;
import cloud.CloudLogger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        try {
            int score = PasswordAnalyzer.calculateScore(password);
            String strength = PasswordAnalyzer.getStrength(score);
            double entropy = PasswordAnalyzer.calculateEntropy(password);
            String hash = HashUtil.hashPassword(password);

            CloudLogger.log("Password analyzed");

            System.out.println("Strength: " + strength);
            System.out.println("Score: " + score);
            System.out.println("Entropy: " + entropy);
            System.out.println("Hash: " + hash);

        } catch (Exception e) {
            System.out.println("Invalid input");
        }

        sc.close();
    }
}

package ui;

import analyzer.PasswordAnalyzer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        TextField input = new TextField();
        input.setPromptText("Enter strong password");

        Button btn = new Button("Analyze");

        Label result = new Label("Result will appear here");

        btn.setOnAction(e -> {

            String password = input.getText();

            if (password.isEmpty()) {
                result.setText("⚠ Please enter a password");
                return;
            }

            try {
                int score = PasswordAnalyzer.calculateScore(password);
                String strength = PasswordAnalyzer.getStrength(score);

                result.setText("✔ " + strength + " | Score: " + score);

            } catch (Exception ex) {
                result.setText("Invalid input");
            }
        });

        VBox root = new VBox(10, input, btn, result);

        stage.setScene(new Scene(root, 300, 200));
        stage.setTitle("Password Analyzer");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

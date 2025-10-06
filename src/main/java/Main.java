import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField valueField = new TextField();
    private Label resultLabel = new Label();
    private double fahrenheit;
    private double kelvin;
    private double celsius;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        valueField.setPromptText("Enter value");

        Button cToFButton = new Button("Celsius to Fahrenheit");
        cToFButton.setOnAction(e -> convertCtoF());

        Button fToCButton = new Button("Fahrenheit to Celsius");
        fToCButton.setOnAction(e -> convertFtoC());

        Button kToCButton = new Button("Kelvin to Celsius");
        kToCButton.setOnAction(e -> convertKtoC());

        Button cToKButton = new Button("Celsius to Kelvin");
        cToKButton.setOnAction(e -> convertCtoK());

    
        Button saveButton = new Button("Save to DB");
        saveButton.setOnAction(e -> Database.saveTemperature(celsius, fahrenheit, resultLabel));

        VBox root = new VBox(10, valueField, cToFButton, fToCButton, kToCButton, cToKButton, resultLabel, saveButton);
        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Temperature Converter");
        stage.setScene(scene);
        stage.show();
    }


    private void convertCtoF() {
        try {
            celsius = Double.parseDouble(valueField.getText()); 
            fahrenheit = (celsius * 9 / 5) + 32;
            resultLabel.setText(String.format("Fahrenheit: %.2f", fahrenheit));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }


    private void convertFtoC() {
        try {
            fahrenheit = Double.parseDouble(valueField.getText());
            celsius = (fahrenheit - 32) * 5 / 9; 
            resultLabel.setText(String.format("Celsius: %.2f", celsius));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }

    private void convertKtoC() {
        try {
            kelvin = Double.parseDouble(valueField.getText());
            celsius = kelvin - 273.15;
            resultLabel.setText(String.format("Celsius: %.2f", celsius));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }

    private void convertCtoK() {
        try {
            celsius = Double.parseDouble(valueField.getText());
            kelvin = celsius + 273.15;
            resultLabel.setText(String.format("Kelvin: %.2f", kelvin));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }
}

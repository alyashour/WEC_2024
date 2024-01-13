package wec.wec_2024;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Natural Disaster Table");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // Replace "path/to/your/file.csv" with the actual path to your CSV file
        String csvFilePath = "src/main/resources/Data/MOCK_DATA.csv";

        try (Scanner scanner = new Scanner(new File(csvFilePath))) {
            // Assuming that the first line contains column headers
            if (scanner.hasNextLine()) {
                String headerLine = scanner.nextLine();
                String[] headers = headerLine.split(",");
                // Process or store column headers as needed
            }

            // Read and process the remaining rows
            while (scanner.hasNextLine()) {
                String dataLine = scanner.nextLine();
                String[] columns = dataLine.split(",");

                // Process or store the data as needed
                for (String column : columns) {
                    System.out.print(column + " ");
                }
                System.out.println(); // Move to the next line for the next row
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        launch();
    }
}

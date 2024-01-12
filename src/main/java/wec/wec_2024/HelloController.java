package wec.wec_2024;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class HelloController {
    @FXML
    private VBox vtop;
    @FXML
    private VBox vbot;
    @FXML
    private CheckBox nameC;
    @FXML
    private CheckBox longC;
    @FXML
    private CheckBox latC;
    @FXML
    private CheckBox dateC;
    @FXML
    private CheckBox typeC;
    @FXML
    private CheckBox intenC;

    @FXML
    private TextField nameT;
    @FXML
    private TextField longT;
    @FXML
    private TextField latT;
    @FXML
    private TextField dateT;
    @FXML
    private TextField typeT;
    @FXML
    private TextField intenT;

    @FXML
    private void initialize() {
        // Initially hide the text field, if the checkbox is not supposed to be checked by default.
        nameT.managedProperty().bind(nameT.visibleProperty());
        nameT.setVisible(nameC.isSelected());

        // Add listener to the checkbox
        nameC.selectedProperty().addListener((observable, oldValue, newValue) -> {
            nameT.setVisible(newValue);
            if (newValue) {
                // Checkbox is selected, add the text field to the container
                if (!vbot.getChildren().contains(nameT)) {
                    vbot.getChildren().add(nameT);
                }
            } else {
                // Checkbox is deselected, remove the text field from the container
                vbot.getChildren().remove(nameT);
            }
        });
    }
}
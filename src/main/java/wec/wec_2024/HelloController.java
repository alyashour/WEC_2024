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
        setupCheckboxWithTextField(nameC, nameT);
        setupCheckboxWithTextField(longC, longT);
        setupCheckboxWithTextField(latC, latT);
        setupCheckboxWithTextField(dateC, dateT);
        setupCheckboxWithTextField(typeC, typeT);
        setupCheckboxWithTextField(intenC, intenT);
    }

    private void setupCheckboxWithTextField(CheckBox checkBox, TextField textField) {
        textField.managedProperty().bind(textField.visibleProperty());
        textField.setVisible(checkBox.isSelected());
        checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            textField.setVisible(newValue);
            if (newValue) {
                if (!vbot.getChildren().contains(textField)) {
                    vbot.getChildren().add(textField);
                }
            } else {
                vbot.getChildren().remove(textField);
            }
        });
    }
}
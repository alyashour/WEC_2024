package wec.wec_2024;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HelloController {
    @FXML
    private TextField filterField;
    @FXML
    private TableView<NaturalDisaster> tableView;
    @FXML
    private TableColumn<NaturalDisaster, String> nameColumn;
    @FXML
    private TableColumn<NaturalDisaster, String> locationColumn;
    @FXML
    private TableColumn<NaturalDisaster, Integer> dateColumn;
    @FXML
    private TableColumn<NaturalDisaster, Integer> intensityColumn;

    private ObservableList<NaturalDisaster> dataList = FXCollections.observableArrayList();

    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        intensityColumn.setCellValueFactory(new PropertyValueFactory<>("intensity"));

        dataList.addAll(
                // Add your sample data here
        );

        FilteredList<NaturalDisaster> filteredData = new FilteredList<>(dataList, b -> true);

        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(naturalDisaster -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (naturalDisaster.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (naturalDisaster.getLocation().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(naturalDisaster.getDate()).contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return String.valueOf(naturalDisaster.getIntensity()).contains(lowerCaseFilter);
                }
            });
        });

        SortedList<NaturalDisaster> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
    }
}

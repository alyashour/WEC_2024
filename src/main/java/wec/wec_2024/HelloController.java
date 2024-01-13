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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HelloController {
    @FXML
    private TextField filterField;
    @FXML
    private TableView<NaturalDisaster> tableView;
    @FXML
    private TableColumn<NaturalDisaster, String> nameColumn;
    @FXML
    private TableColumn<NaturalDisaster, Double> longcolumn;
    @FXML
    private TableColumn<NaturalDisaster, Double> latcolumn;
    @FXML
    private TableColumn<NaturalDisaster, String> dateColumn;
    @FXML
    private TableColumn<NaturalDisaster, Integer> intensityColumn;
    @FXML
    private TableColumn<NaturalDisaster, String> typecolumn;

    private ObservableList<NaturalDisaster> dataList = FXCollections.observableArrayList();

    public void initialize() throws FileNotFoundException {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        latcolumn.setCellValueFactory(new PropertyValueFactory<>("long"));
        longcolumn.setCellValueFactory(new PropertyValueFactory<>("lat"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        intensityColumn.setCellValueFactory(new PropertyValueFactory<>("intensity"));
        typecolumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        ArrayList<String[]> data = findData();
        ArrayList<NaturalDisaster> data_al = dataToArrayList(data);

        dataList.addAll(
                // Add your sample data here
                data_al
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

    private ArrayList<NaturalDisaster> dataToArrayList(ArrayList<String[]> data) {
        ArrayList<NaturalDisaster> arrayList = new ArrayList<>();
        for (String[] s : data){
            // make natural disaster object
            NaturalDisaster nd = new NaturalDisaster(
                    s[0],
                    Double.parseDouble(s[1]),
                    Double.parseDouble(s[2]),
                    s[3],
                    Integer.parseInt(s[4]),
                    s[5]
            );

            arrayList.add(nd);
        }

        return arrayList;
    }

    private ArrayList<String[]> findData() throws FileNotFoundException {
        // Replace "path/to/your/file.csv" with the actual path to your CSV file
        String csvFilePath = "src/main/resources/Data/MOCK_DATA.csv";

        Scanner scanner = new Scanner(new File(csvFilePath));
        // Assuming that the first line contains column headers
        // not needed
        String[] headers;
        if (scanner.hasNextLine()) {
            String headerLine = scanner.nextLine();
            headers = headerLine.split(",");
            // Process or store column headers as needed
        }

        // Read and process the remaining rows
        ArrayList<String[]> disasters = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String dataLine = scanner.nextLine();
            disasters.add(dataLine.split(","));
        }

        // String[] columns contain all the data
        return disasters;
    }
}

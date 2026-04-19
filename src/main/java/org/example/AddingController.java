package org.example;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddingController {
    @FXML
    public TextField dishNameTextField;
    @FXML
    public Button addButon;
    @FXML
    public TableView<Row> IngredientsTableView = new TableView<>();
    @FXML
    private Label welcomeText;
    @FXML
    private ListView<String> IngredientsListView;
    @FXML
    private TextField Ingredient;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("AddingView");
    }
    @FXML
    protected void initialize() {
        TableColumn<Row, String> nameColumn = new TableColumn<>("Składnik");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        TableColumn<Row, String> quantityColumn = new TableColumn<>("Ilość");
        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        TableColumn<Row, String> unitColumn = new TableColumn<>("Jednostka");
        unitColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        IngredientsTableView.getColumns().addAll(nameColumn, quantityColumn, unitColumn);

    }

    @FXML
    protected void onAddButtonClick() {
        IngredientsListView.getItems().add(Ingredient.getText());
    }

}


class Row{
    SimpleStringProperty  name;
    SimpleStringProperty  quantity;
    SimpleStringProperty unit;

    public ObservableValue<String> nameProperty() {
        return name;
    }
    public ObservableValue<String> quantityProperty() {
        return quantity;
    }
    public ObservableValue<String> unitProperty() {
        return unit;
    }
}

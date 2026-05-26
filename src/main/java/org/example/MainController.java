package org.example;

import grammar.firstLexer;
import grammar.firstParser;
import interpreter.DishVisitor;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.Dish;
import models.Guest;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    // ── TAB PANE ──────────────────────────────────────────────────────────
    @FXML private TabPane mainTabPane;

    // ── GUEST FORM ────────────────────────────────────────────────────────
    @FXML private TextField guestNameField;
    @FXML private TextField guestAllergyField;   // single allergen to add
    @FXML private ListView<String> guestAllergyList; // allergies for current guest
    @FXML private TableView<Guest> guestsTable;
    @FXML private TableColumn<Guest, String> guestNameCol;
    @FXML private TableColumn<Guest, String> guestAllergiesCol;

    // ── DISH FORM ─────────────────────────────────────────────────────────
    @FXML private TextField dishNameField;
    @FXML private TextField dishAllergenField;
    @FXML private ListView<String> dishAllergenList;
    @FXML private TextField dishIngredientField;
    @FXML private ListView<String> dishIngredientList;
    @FXML private TableView<Dish> dishesTable;
    @FXML private TableColumn<Dish, String> dishNameCol;
    @FXML private TableColumn<Dish, String> dishAllergensCol;

    // ── DSL EDITOR ────────────────────────────────────────────────────────
    @FXML private TextArea dslEditor;

    // ── STATUS ────────────────────────────────────────────────────────────
    @FXML private Label statusLabel;

    // ── DATA ──────────────────────────────────────────────────────────────
    private final ObservableList<Guest> guests = FXCollections.observableArrayList();
    private final ObservableList<Dish>  dishes  = FXCollections.observableArrayList();

    // ─────────────────────────────────────────────────────────────────────
    @FXML
    public void initialize() {
        // Guests table
        guestNameCol.setCellValueFactory(
                cd -> new SimpleStringProperty(cd.getValue().name));
        guestAllergiesCol.setCellValueFactory(
                cd -> new SimpleStringProperty(String.join(", ", cd.getValue().allergies)));
        guestsTable.setItems(guests);

        // Dishes table
        dishNameCol.setCellValueFactory(
                cd -> new SimpleStringProperty(cd.getValue().name));
        dishAllergensCol.setCellValueFactory(
                cd -> new SimpleStringProperty(String.join(", ", cd.getValue().allergens)));
        dishesTable.setItems(dishes);

        // Whenever the user switches to the DSL tab, regenerate the DSL text
        mainTabPane.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldTab, newTab) -> {
                    if (newTab != null && "DSL Editor".equals(newTab.getText())) {
                        dslEditor.setText(buildDsl());
                    }
                });

        // Auto-load saved data on startup
        try {
            String dsl = java.nio.file.Files.readString(java.nio.file.Path.of("data.dsl"));
            firstLexer lexer = new firstLexer(CharStreams.fromString(dsl));
            firstParser parser = new firstParser(new CommonTokenStream(lexer));
            DishVisitor visitor = new DishVisitor();
            visitor.visit(parser.program());
            guests.setAll(visitor.guests);
            dishes.setAll(visitor.dishes);
        } catch (Exception ignored) {}
    }

    // ── GUEST ACTIONS ─────────────────────────────────────────────────────

    /** Add a single allergen to the current-guest allergy list */
    @FXML
    protected void onAddGuestAllergyClick() {
        String text = guestAllergyField.getText().trim();
        if (!text.isEmpty()) {
            guestAllergyList.getItems().add(text);
            guestAllergyField.clear();
        }
    }

    /** Remove the selected allergen from the current-guest allergy list */
    @FXML
    protected void onRemoveGuestAllergyClick() {
        int idx = guestAllergyList.getSelectionModel().getSelectedIndex();
        if (idx >= 0) guestAllergyList.getItems().remove(idx);
    }

    /** Commit the guest form into the guests table */
    @FXML
    protected void onAddGuestClick() {
        String name = guestNameField.getText().trim();
        if (name.isEmpty()) {
            setStatus("Guest name cannot be empty.", true);
            return;
        }
        Guest g = new Guest();
        g.name = name;
        g.allergies = new ArrayList<>(guestAllergyList.getItems());
        guests.add(g);

        // clear form
        guestNameField.clear();
        guestAllergyList.getItems().clear();
        setStatus("Guest \"" + name + "\" added.", false);
    }

    /** Remove the selected row from the guests table */
    @FXML
    protected void onRemoveGuestClick() {
        Guest selected = guestsTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            guests.remove(selected);
            setStatus("Guest \"" + selected.name + "\" removed.", false);
        }
    }

    // ── DISH ACTIONS ──────────────────────────────────────────────────────

    @FXML
    protected void onAddDishAllergenClick() {
        String text = dishAllergenField.getText().trim();
        if (!text.isEmpty()) {
            dishAllergenList.getItems().add(text);
            dishAllergenField.clear();
        }
    }

    @FXML
    protected void onRemoveDishAllergenClick() {
        int idx = dishAllergenList.getSelectionModel().getSelectedIndex();
        if (idx >= 0) dishAllergenList.getItems().remove(idx);
    }

    @FXML
    protected void onAddDishIngredientClick() {
        String text = dishIngredientField.getText().trim();
        if (!text.isEmpty()) {
            dishIngredientList.getItems().add(text);
            dishIngredientField.clear();
        }
    }

    @FXML
    protected void onRemoveDishIngredientClick() {
        int idx = dishIngredientList.getSelectionModel().getSelectedIndex();
        if (idx >= 0) dishIngredientList.getItems().remove(idx);
    }

    @FXML
    protected void onAddDishClick() {
        String name = dishNameField.getText().trim();
        if (name.isEmpty()) {
            setStatus("Dish name cannot be empty.", true);
            return;
        }
        Dish d = new Dish();
        d.name = name;
        d.allergens   = new ArrayList<>(dishAllergenList.getItems());
        d.ingredients = new ArrayList<>(dishIngredientList.getItems());
        dishes.add(d);

        dishNameField.clear();
        dishAllergenList.getItems().clear();
        dishIngredientList.getItems().clear();
        setStatus("Dish \"" + name + "\" added.", false);
    }

    @FXML
    protected void onSaveClick() {
        String dsl = buildDsl();
        if (dsl.isBlank()) {
            setStatus("Nothing to save.", true);
            return;
        }
        try {
            java.nio.file.Files.writeString(
                    java.nio.file.Path.of("data.dsl"), dsl);
            setStatus("Saved to data.dsl", false);
        } catch (Exception e) {
            setStatus("Save failed: " + e.getMessage(), true);
        }
    }

    @FXML
    protected void onLoadClick() {
        try {
            String dsl = java.nio.file.Files.readString(
                    java.nio.file.Path.of("data.dsl"));

            // Parse and repopulate the lists
            firstLexer lexer = new firstLexer(CharStreams.fromString(dsl));
            firstParser parser = new firstParser(new CommonTokenStream(lexer));
            DishVisitor visitor = new DishVisitor();
            visitor.visit(parser.program());

            guests.setAll(visitor.guests);
            dishes.setAll(visitor.dishes);
            setStatus("Loaded from data.dsl", false);
        } catch (java.nio.file.NoSuchFileException e) {
            setStatus("No save file found.", true);
        } catch (Exception e) {
            setStatus("Load failed: " + e.getMessage(), true);
        }
    }

    @FXML
    protected void onRemoveDishClick() {
        Dish selected = dishesTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            dishes.remove(selected);
            setStatus("Dish \"" + selected.name + "\" removed.", false);
        }
    }

    // ── DSL EDITOR ACTIONS ────────────────────────────────────────────────

    /** Manually triggered "regenerate DSL from form data" button */
    @FXML
    protected void onRegenerateDslClick() {
        dslEditor.setText(buildDsl());
        setStatus("DSL regenerated from form data.", false);
    }

    // ── RUN ───────────────────────────────────────────────────────────────

    /**
     * Parse whichever DSL is currently in the editor (which may have been
     * hand-edited) and open the Results screen.
     */
    @FXML
    protected void onRunClick() {
        // If user is on DSL tab, use the editor text; otherwise regenerate
        String dsl = dslEditor.getText();
        if (dsl == null || dsl.isBlank()) {
            dsl = buildDsl();
        }

        if (dsl.isBlank()) {
            setStatus("Nothing to run — add guests and dishes first.", true);
            return;
        }

        try {
            // ── Run ANTLR ──
            firstLexer lexer   = new firstLexer(CharStreams.fromString(dsl));
            firstParser parser = new firstParser(new CommonTokenStream(lexer));

            // Capture syntax errors
            SyntaxErrorListener errorListener = new SyntaxErrorListener();
            parser.removeErrorListeners();
            parser.addErrorListener(errorListener);

            var tree = parser.program();

            if (!errorListener.getErrors().isEmpty()) {
                setStatus("Syntax error: " + errorListener.getErrors().get(0), true);
                return;
            }

            DishVisitor visitor = new DishVisitor();
            visitor.visit(tree);

            // ── Open results screen ──
            FXMLLoader loader = new FXMLLoader(
                    HelloApplication.class.getResource("results-view.fxml"));
            Scene resultsScene = new Scene(loader.load(), 900, 600);

            ResultsController rc = loader.getController();
            rc.setData(visitor.guests, visitor.dishes);

            Stage stage = (Stage) mainTabPane.getScene().getWindow();
            stage.setScene(resultsScene);
            stage.show();

        } catch (Exception e) {
            setStatus("Error: " + e.getMessage(), true);
            e.printStackTrace();
        }
    }

    // ── HELPERS ───────────────────────────────────────────────────────────

    /**
     * Builds a valid DSL string from the current guests and dishes lists.
     * Format matches first.g4:
     *   guest "Jan Kowalski" { allergies: gluten, lactose; }
     *   dish  "Spaghetti"   { ingredients: pasta; allergens: gluten; }
     */
    private String buildDsl() {
        StringBuilder sb = new StringBuilder();

        for (Guest g : guests) {
            // Names in the grammar are NAME+ (letters only, space-separated)
            sb.append("guest \"").append(g.name).append("\" {\n");
            if (!g.allergies.isEmpty()) {
                sb.append("    allergies: ")
                  .append(String.join(", ", g.allergies))
                  .append(";\n");
            }
            sb.append("}\n\n");
        }

        for (Dish d : dishes) {
            sb.append("dish \"").append(d.name).append("\" {\n");
            if (!d.ingredients.isEmpty()) {
                sb.append("    ingredients: ")
                  .append(String.join(", ", d.ingredients))
                  .append(";\n");
            }
            if (!d.allergens.isEmpty()) {
                sb.append("    allergens: ")
                  .append(String.join(", ", d.allergens))
                  .append(";\n");
            }
            sb.append("}\n\n");
        }

        return sb.toString().trim();
    }

    private void setStatus(String message, boolean isError) {
        statusLabel.setText(message);
        statusLabel.setStyle(isError
                ? "-fx-text-fill: #cc0000;"
                : "-fx-text-fill: #007700;");
    }
}

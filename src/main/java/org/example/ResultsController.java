package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Dish;
import models.Guest;

import java.io.IOException;
import java.util.List;

public class ResultsController {

    @FXML private VBox resultsBox;       // container where result cards go
    @FXML private Label summaryLabel;    // e.g. "3 guests, 5 dishes"
    @FXML private ScrollPane scrollPane;

    /**
     * Called by MainController after loading the FXML.
     * Runs the allergy-matching logic and populates the UI.
     */
    public void setData(List<Guest> guests, List<Dish> dishes) {
        summaryLabel.setText(
                guests.size() + " guest(s)  ·  " + dishes.size() + " dish(es)");

        resultsBox.getChildren().clear();

        if (guests.isEmpty()) {
            resultsBox.getChildren().add(new Label("No guests found in the DSL."));
            return;
        }

        for (Guest guest : guests) {
            // ── Card per guest ──
            VBox card = new VBox(6);
            card.setStyle("""
                    -fx-background-color: #f4f4f4;
                    -fx-border-color: #cccccc;
                    -fx-border-radius: 6;
                    -fx-background-radius: 6;
                    -fx-padding: 12;
                    """);

            // Guest header
            Label guestLabel = new Label("👤 " + guest.name);
            guestLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

            String allergyText = guest.allergies.isEmpty()
                    ? "No known allergies"
                    : "Allergic to: " + String.join(", ", guest.allergies);
            Label allergyLabel = new Label(allergyText);
            allergyLabel.setStyle("-fx-text-fill: #555555; -fx-font-size: 11px;");

            card.getChildren().addAll(guestLabel, allergyLabel);

            // Safe dishes
            boolean anySafe = false;
            for (Dish dish : dishes) {
                boolean safe = guest.allergies.stream()
                        .noneMatch(a -> dish.allergens.contains(a));
                if (safe) {
                    Label dishLabel = new Label("  ✅  " + dish.name);
                    dishLabel.setStyle("-fx-text-fill: #2a7a2a;");
                    card.getChildren().add(dishLabel);
                    anySafe = true;
                }
            }

            if (!anySafe) {
                Label noneLabel = new Label("  ⚠️  No safe dishes found.");
                noneLabel.setStyle("-fx-text-fill: #cc0000;");
                card.getChildren().add(noneLabel);
            }

            resultsBox.getChildren().add(card);
        }
    }

    /** Go back to the main screen */
    @FXML
    protected void onBackClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                HelloApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(loader.load(), 900, 600);
        Stage stage = (Stage) resultsBox.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onSaveResultsClick() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Diet Event Planner — Results ===\n");
        sb.append("Generated: ").append(java.time.LocalDateTime.now()
                .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))).append("\n\n");

        for (javafx.scene.Node node : resultsBox.getChildren()) {
            if (!(node instanceof VBox card)) continue;

            for (javafx.scene.Node child : card.getChildren()) {
                if (!(child instanceof Label lbl)) continue;
                String text = lbl.getText();
                if (text.startsWith("👤")) {
                    sb.append("\n").append(text.replace("👤 ", "")).append("\n");
                } else if (text.startsWith("Allergic") || text.startsWith("No known")) {
                    sb.append("  ").append(text).append("\n");
                } else if (text.contains("✅")) {
                    sb.append("  SAFE: ").append(text.replace("  ✅  ", "")).append("\n");
                } else if (text.contains("⚠️")) {
                    sb.append("  WARNING: No safe dishes found.\n");
                }
            }
        }

        try {
            java.nio.file.Files.writeString(java.nio.file.Path.of("results.txt"), sb.toString());
            summaryLabel.setText(summaryLabel.getText() + "  ✅ Saved to results.txt");
        } catch (Exception e) {
            summaryLabel.setText("Save failed: " + e.getMessage());
        }
    }
}

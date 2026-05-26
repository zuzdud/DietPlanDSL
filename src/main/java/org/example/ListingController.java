package org.example;

import eu.hansolo.toolbox.tuples.Pair;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import static org.example.HelloApplication.stack;

public class ListingController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("adding-view.fxml"));
        Stage stage = (Stage) welcomeText.getScene().getWindow();

        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
        stack.push(new Pair<>(scene, "DietEventPlanner"));
        stage.setTitle(stack.peek().getB());
        stage.setScene(stack.peek().getA());

        stage.show();
    }
}

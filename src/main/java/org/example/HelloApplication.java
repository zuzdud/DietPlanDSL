package org.example;

import eu.hansolo.toolbox.tuples.Pair;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

public class HelloApplication extends Application {
    public static Stack<Pair<Scene, String>> stack = new Stack<>();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
        stack.push(new Pair<>(scene, "DietEventPlanner"));
        stage.setTitle(stack.peek().getB());
        stage.setScene(stack.peek().getA());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
package com.projectlearn;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class Main extends Application{

    public static void main(String... args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn = new Button("Click me");
        btn.setOnAction(e -> System.out.println("Hello!!!"));

        StackPane root = new StackPane();
        root.getChildren().addAll(btn);

        Scene scene = new Scene(root, 500, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }


}

package com.projectlearn.business.finance;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javafx.application.Application;

import java.util.HashMap;

//Image url https://cdn.wallpapersafari.com/2/63/xcqYZ8.jpg

//testing class
public class MainAccount extends Application{


    public static void main (String... args) {
        AccountList accounts = new AccountList();
        int num = 1234;
        int balance = 10;
        String name = "hello";
        Account stefan = new Account(num, balance, "Stefan", "sell488sftoday@gmail.com", "1234", 12, "Owner");
        accounts.setAccounts(num, stefan);

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("finance.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("finance.css").toExternalForm());
        primaryStage.setTitle("Finances");
        primaryStage.setScene(scene);
        primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.projectlearn.business.finance;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javafx.application.Application;

import java.util.HashMap;

//testing class
public class MainAccount extends Application{


    public static void main (String... args) {
        AccountList accounts = new AccountList();
        int num = 1234;
        int balance = 1234;
        Account stefan = new Account(num, balance, "Stefan", "sell488sftoday@gmail.com", "1234", 12, "Owner");
        accounts.setAccounts(num, stefan);

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try{
            //BorderPane root = new BorderPane();
        Parent root = FXMLLoader.load(getClass().getResource("finance.fxml"));
        Scene scene = new Scene(root,800, 600);
        scene.getStylesheets().add(getClass().getResource("finance.css").toExternalForm());
        primaryStage.setTitle("Finances");
        primaryStage.setScene(scene);
        primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

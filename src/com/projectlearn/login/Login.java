package com.projectlearn.login;

import com.projectlearn.finance.Account;
import com.projectlearn.finance.AccountList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class Login extends Application {
    //TODO REORGANIZE PACKAGES
    public  Stage stage;
    public Scene mainAccountScene;

    public static void main(String[] args) throws Exception{
        //default account
        AccountList accounts = new AccountList();
        int num = 1234;
        int balance = 10;
        Account stefan = new Account(num, balance, "Stefan", "sell488sftoday@gmail.com", "1234", 12, "Owner");
        accounts.setAccounts(num, stefan);

        File accountsStored = new File("Accounts Stored.txt");
        FileOutputStream fos = new FileOutputStream(accountsStored);
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeUTF("Accounts Content");

        FileInputStream fis = new FileInputStream(accountsStored);
        DataInputStream dis = new DataInputStream(fis);
        String str = dis.readUTF();
        System.out.println(str);

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/com/projectlearn/login/login.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}

package com.projectlearn.login;

import com.projectlearn.finance.Account;
import com.projectlearn.finance.AccountList;
import com.projectlearn.finance.Permissions;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.*;
import java.util.HashMap;
import java.util.Set;

public class Main extends Application {
    //TODO REORGANIZE PACKAGES
    public  Stage stage;
    public Scene mainAccountScene;

    HashMap<String, Permissions> permissionsHashMap = new HashMap<>();

    public static Set<Permissions> admin = Set.of(Permissions.CAN_HIRE, Permissions.CAN_FIRE, Permissions.CAN_DEPOSIT, Permissions.CAN_WITHDRAW, Permissions.CAN_PAY, Permissions.CAN_FINE, Permissions.CAN_VIEW_ACCOUNTS);
    public static Set<Permissions> intern = Set.of(Permissions.CAN_WITHDRAW);
    public static Set<Permissions> employee = Set.of(Permissions.CAN_DEPOSIT, Permissions.CAN_WITHDRAW);
    public static Set<Permissions> hr = Set.of(Permissions.CAN_DEPOSIT, Permissions.CAN_WITHDRAW, Permissions.CAN_HIRE, Permissions.CAN_FIRE, Permissions.CAN_PAY, Permissions.CAN_VIEW_ACCOUNTS);
    public static Set<Permissions> it = Set.of(Permissions.CAN_DEPOSIT, Permissions.CAN_WITHDRAW, Permissions.CAN_VIEW_ACCOUNTS);

    public static void main(String[] args) throws Exception{

        //default account
        AccountList accounts = new AccountList();
        int num = 1234;
        int balance = 10;
        Account stefan = new Account(num, balance, "Stefan", "sell488sftoday@gmail.com", "1234", 12, "Owner", admin);
        accounts.setAccounts(num, stefan);

        int num2 = 0000;
        int balance2 = 30;
        Account internBob = new Account(num2, balance2, "Bob", "Testing@gmail.com", "1234", 0, "Intern", intern);
        accounts.setAccounts(num2, internBob);




//        FileInputStream fis = new FileInputStream(accountsStored);
//        DataInputStream dis = new DataInputStream(fis);
//        String str = dis.readUTF();
//        System.out.println(str);

        launch(args);
    }

    public static void storeAccount(int accountNum, Account account) throws Exception{
        File accountsStored = new File("Accounts Stored.txt");
        FileOutputStream fos = new FileOutputStream(accountsStored);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(accountNum);
        oos.writeObject(account);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/com/projectlearn/login/login.fxml"));
        Scene scene = new Scene(root);

        scene.getStylesheets().add(getClass().getResource("/com/projectlearn/login/login.css").toExternalForm());

        primaryStage.getIcons().add(new Image("/com/projectlearn/finance/ProjectLearn_Logo.png"));

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}

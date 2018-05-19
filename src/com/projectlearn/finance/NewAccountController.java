package com.projectlearn.finance;

import com.projectlearn.login.LoginController;
import com.projectlearn.login.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.Set;


public class NewAccountController {

    AccountManager accountManager;

    //Displays a warning if a user tries to make an account with an existing account number
    @FXML
    private Label alreadyInUse;

    //Creates the new account and adds it to the HashMap
    @FXML
    private Button done;
    //Goes back to login screen
    @FXML
    private Button quit;

    //These textfields are where the user enters their prefered account info
    @FXML
    private TextField accountNum;
    @FXML
    private TextField name;
    @FXML
    private TextField password;
    @FXML
    private TextField email;
    @FXML
    private TextField ID;

    //This choicebox allows the user to select their account type
    @FXML
    private ChoiceBox type;

    //All the available options for an account type
    ObservableList<String> types = FXCollections.observableArrayList("Intern", "Employee", "Team Leader", "IT", "IT Manager", "Manager", "HR", "HR Manager", "Admin", "CEO");

    @FXML
    private void initialize() {
        type.setItems(types);
        type.setValue("Employee");
    }

    //ActionHandler for a done button
    @FXML
    public void addNewAccount (ActionEvent event) throws IOException {
        try {
            System.out.println(accountManager.getList().size());
            //gets all of the information that the user entered
            int accountInt = Integer.parseInt(accountNum.getText());
            int balance = 0;
            String nameString = name.getText();
            String passwordInt = password.getText();
            String emailString = email.getText();
            int IDInt = Integer.parseInt(ID.getText());
            String accountTypeString = String.valueOf(type.getValue());
            System.out.println(type.getValue());
            if(!accountManager.getList().containsKey(accountInt)) {
                Account newAccount = new Account(accountInt, balance, nameString, emailString, passwordInt, IDInt,accountTypeString, getPermissionLevel(accountTypeString));
                accountManager.setAccounts(accountInt, newAccount);

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/projectlearn/login/login.fxml"));

                Parent roots = fxmlLoader.load();
                LoginController loginController = fxmlLoader.<LoginController>getController();
                loginController.setAccountManager(accountManager);

                Scene scene = new Scene(roots);

                Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

                scene.getStylesheets().add(getClass().getResource("/com/projectlearn/finance/finance.css").toExternalForm());

                root.setScene(scene);
                root.setResizable(false);
                root.show();

            }

            else {
                alreadyInUse.setText("Sorry, but that account number is taken! Please choose another one and try again!");
            }

            System.out.println(accountManager.getList().size());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


    }

    //Changes back to login screen
    @FXML
    public void quitCreation(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/projectlearn/login/login.fxml"));

        Parent roots = fxmlLoader.load();
        LoginController loginController = fxmlLoader.<LoginController>getController();
        loginController.setAccountManager(accountManager);

        Scene scene = new Scene(roots);

        Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

        scene.getStylesheets().add(getClass().getResource("/com/projectlearn/finance/finance.css").toExternalForm());

        root.setScene(scene);
        root.setResizable(false);
        root.show();
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public Set getPermissionLevel(String accountType) {
        if (accountType.equals("Intern")) {
            return accountManager.intern;
        }
        else if (accountType.equals("Employee")) {
            return  accountManager.employee;
        }
        else if (accountType.equals("Team Leader")) {
            return  accountManager.hr;
        }
        else if (accountType.equals("IT")) {
            return accountManager.it;
        }
        else if (accountType.equals("IT Manager")) {
            return accountManager.it;
        }

        else if (accountType.equals("Manager")) {
            return accountManager.admin;
        }
        else if (accountType.equals("HR")) {
            return accountManager.hr;
        }
        else if (accountType.equals("HR Manager")) {
            return accountManager.hr;
        }
        else if (accountType.equals("Admin")) {
            return accountManager.admin;
        }
        else if (accountType.equals("CEO")) {
            return accountManager.admin;
        }

        else {
            return accountManager.noPerms;
        }
    }

}

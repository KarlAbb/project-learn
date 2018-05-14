package com.projectlearn.finance;

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


public class NewAccountController {

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
            //gets all of the information that the user entered
            int accountInt = Integer.parseInt(accountNum.getText());
            int balance = 0;
            String nameString = name.getText();
            String passwordInt = password.getText();
            String emailString = email.getText();
            int IDInt = Integer.parseInt(ID.getText());
            String accountTypeString = type.getTypeSelector();
            if(!AccountList.getList().containsKey(accountInt)) {
                if (accountTypeString.equals("Intern")) {
                    Account newAccount = new Account(accountInt, balance, nameString, emailString, passwordInt, IDInt, accountTypeString, StandardPermissions.ADMIN);
                    AccountList.setAccounts(accountInt, newAccount);
                    System.out.println(AccountList.getAccount(accountInt).getName());
//            AccountList.getList().put(accountInt, newAccount);

                    Main.storeAccount(accountInt, newAccount);
                }
                else if (accountTypeString == "Employee") {
                    Account newAccount = new Account(accountInt, balance, nameString, emailString, passwordInt, IDInt, accountTypeString, Main.employee);
                    AccountList.setAccounts(accountInt, newAccount);
                    System.out.println(AccountList.getAccount(accountInt).getName());
                    Main.storeAccount(accountInt, newAccount);
                }
                else if (accountTypeString == "Team Leader") {

                }
                else if (accountTypeString == "IT") {
                    Account newAccount = new Account(accountInt, balance, nameString, emailString, passwordInt, IDInt, accountTypeString, Main.it);
                    AccountList.setAccounts(accountInt, newAccount);
                    System.out.println(AccountList.getAccount(accountInt).getName());
                    Main.storeAccount(accountInt, newAccount);
                }
                else if (accountTypeString == "IT Manager") {

                }

                else if (accountTypeString == "Manager") {

                }
                else if (accountTypeString == "HR") {
                    Account newAccount = new Account(accountInt, balance, nameString, emailString, passwordInt, IDInt, accountTypeString, Main.hr);
                    AccountList.setAccounts(accountInt, newAccount);
                    System.out.println(AccountList.getAccount(accountInt).getName());
                    Main.storeAccount(accountInt, newAccount);
                }
                else if (accountTypeString == "HR Manager") {

                }
                else if (accountTypeString == "Admin") {
                    Account newAccount = new Account(accountInt, balance, nameString, emailString, passwordInt, IDInt, accountTypeString, Main.admin);
                    AccountList.setAccounts(accountInt, newAccount);
                    System.out.println(AccountList.getAccount(accountInt).getName());
                    Main.storeAccount(accountInt, newAccount);
                }
                else if (accountTypeString == "CEO") {

                }

                //Changes back to login screen
                Parent login = FXMLLoader.load(getClass().getResource("/com/projectlearn/login/login.fxml"));
                Scene loginScene = new Scene(login);

                Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

                root.setScene(loginScene);
                root.show();
            }

            else {
                alreadyInUse.setText("Sorry, but that account number is taken! Please choose another one and try again!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


    }

    //Changes back to login screen
    @FXML
    public void quitCreation(ActionEvent event) throws Exception {
        Parent login = FXMLLoader.load(getClass().getResource("/com/projectlearn/login/login.fxml"));
        Scene loginScene = new Scene(login);

        Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

        root.setScene(loginScene);
        root.show();
    }
}

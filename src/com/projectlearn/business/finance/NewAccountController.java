package com.projectlearn.business.finance;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;


public class NewAccountController {

    @FXML
    private Button done;

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
    @FXML
    private TextField accountType;

    @FXML
    private ChoiceBox type;

    ObservableList<String> types = FXCollections.observableArrayList("Intern", "Employee", "Team Leader", "IT", "IT Manager", "Manager", "HR", "HR Manager", "Admin", "CEO");

    @FXML
    private void initialize() {
        type.setItems(types);
        type.setValue("Employee");
    }

    @FXML
    public void addNewAccount (ActionEvent event) throws IOException {
        try {

            int accountInt = Integer.parseInt(accountNum.getText());
            int balance = 0;
            String nameString = name.getText();
            String passwordInt = password.getText();
            String emailString = email.getText();
            int IDInt = Integer.parseInt(ID.getText());
            String accountTypeString = type.getTypeSelector();
            Account newAccount = new Account(accountInt, balance, nameString, emailString, passwordInt, IDInt, accountTypeString);
            AccountList.getList().put(accountInt, newAccount);

            Parent mainAccount = FXMLLoader.load(getClass().getResource("/gui/login/login.fxml"));
            Scene mainAccountScene = new Scene(mainAccount);
//            mainAccountScene.getStylesheets().add(getClass().getResource("finance.css").toExternalForm());

            Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

            root.setScene(mainAccountScene);
            root.show();

        } catch (Exception e) {
            System.out.println("Error: IO Exception");
        }


    }
}

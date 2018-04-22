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

import java.awt.event.ActionEvent;
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
        type.setValue("Intern");
    }

    @FXML
    public void addNewAccount (ActionEvent event) throws IOException {
        try {
            Parent mainAccount = FXMLLoader.load(getClass().getResource("finance.FXML"));
            Scene mainAccountScene = new Scene(mainAccount);

            Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

            root.setScene(mainAccountScene);
            root.show();
        } catch (Exception e) {
            System.out.println("Error: IO Exception");
        }


    }
}

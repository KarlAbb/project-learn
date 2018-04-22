package com.projectlearn.business.finance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class FinanceController {


    @FXML
    private AnchorPane finance;

    @FXML
    private Label account;

    @FXML
    private Label balance;

    @FXML
    private Button deposit;

    @FXML
    private Button withdraw;

    @FXML
    private Button newAccount;

    @FXML
    private TextField amount;

    @FXML
    private TextField accountNum;

    @FXML
    private TextField withdrawAmount;


    //inital Account display
    public void welcome () {
            accountNum.setOnAction((event -> {
            account.setText("Welcome " + AccountList.getAccount(Integer.parseInt(accountNum.getText())).getName() + "!");
            balance.setText(AccountList.getAccount(Integer.parseInt(accountNum.getText())).getBalance() + "");
        }));


    }

    //deposit ActionHandler
    public void deposit(ActionEvent event) {
        int accountID = Integer.parseInt(accountNum.getText());
        System.out.println(accountID);
        int depositAmount = Integer.parseInt(amount.getText());
        System.out.println(depositAmount);
        balance.setText(AccountList.getAccount(accountID).deposit(depositAmount) + "");
    }

    public void withdraw(ActionEvent event) {
        int accountID = Integer.parseInt(accountNum.getText());
        System.out.println(accountID);
        int withdrawValue = Integer.parseInt(withdrawAmount.getText());
        System.out.println(withdrawAmount);
        balance.setText(AccountList.getAccount(accountID).withdraw(withdrawValue) + "");
    }


    public void newAccount (ActionEvent event) throws IOException{
                Parent newAccountParent = FXMLLoader.load(getClass().getResource("newAccount.fxml"));
                Scene newAccountScene = new Scene(newAccountParent);

                Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

                root.setScene(newAccountScene);
                root.show();

    }


}

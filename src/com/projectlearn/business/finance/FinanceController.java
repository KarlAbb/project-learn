package com.projectlearn.business.finance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
    private TextField amount;

    @FXML
    private TextField accountNum;

    @FXML
    private TextField withdrawAmount;


    public void welcome () {
        accountNum.setOnAction((event -> {
            account.setText("Welcome " + Account.getAccountName(Integer.parseInt(accountNum.getText())) + "!");
            balance.setText(Integer.toString(Account.getAccountBalance((Integer.parseInt(accountNum.getText())))));

        }));
    }

    public void deposit(ActionEvent event) {
        int accountID = Integer.parseInt(accountNum.getText());
        System.out.println(accountID);
        int depositAmount = Integer.parseInt(amount.getText());
        System.out.println(depositAmount);
        Account.deposit(accountID, depositAmount);
        String amountLabel = Integer.toString(depositAmount);
        System.out.println(Account.getAccountBalance((Integer.parseInt(accountNum.getText()))));
        balance.setText(Integer.toString(Account.getAccountBalance((Integer.parseInt(accountNum.getText())))));
    }

    public void withdraw(ActionEvent event) {
    }


    public void depositTen(ActionEvent event) {

    }
}

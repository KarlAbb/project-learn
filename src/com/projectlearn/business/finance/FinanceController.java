package com.projectlearn.business.finance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Random;

public class FinanceController {

    AccountList accountList = new AccountList();
    HashMap<Integer, Account> accounts = accountList.getAccounts();

    @FXML
    private Label rando;

    @FXML
    private Button deposit;

    @FXML
    private TextField amount;

    @FXML
    private TextField accountNum;

    public void deposit(ActionEvent event) {
        int depositAmount = Integer.parseInt(amount.getText());
        Account account = accountList.getAccounts(Integer.parseInt(accountNum.getText()));
        int balance = account.getBalance() + depositAmount;
        account.setBalance(balance);
    }

    public void generateRandom(ActionEvent event) {
        Random rand = new Random();
        int myRand = rand.nextInt(50) + 1;
        rando.setText(Integer.toString(myRand));
    }

    public void depositTen(ActionEvent event) {

    }
}

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
    private Label rando;

    @FXML
    private Button deposit;

    @FXML
    private TextField amount;

    @FXML
    private TextField accountNum;

    public void deposit(ActionEvent event) {
        int accountID = Integer.parseInt(accountNum.getText());
        System.out.println(accountID);
        int depositAmount = Integer.parseInt(amount.getText());
        System.out.println(depositAmount);
        Account.deposit(accountID, depositAmount);
        String amountLabel = Integer.toString(depositAmount);
        rando.setText(amountLabel);
    }



    public void generateRandom(ActionEvent event) {
        Random rand = new Random();
        int myRand = rand.nextInt(50) + 1;
        rando.setText(Integer.toString(myRand));
    }

    public void depositTen(ActionEvent event) {

    }
}

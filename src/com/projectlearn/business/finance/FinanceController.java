package com.projectlearn.business.finance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class FinanceController {

    @FXML
    private Label rando;

    @FXML
    private Button deposit;

    @FXML
    private TextField amount;

    public void deposit(ActionEvent event) {
        amount.getText();


    }

    public void generateRandom(ActionEvent event) {
        Random rand = new Random();
        int myRand = rand.nextInt(50) + 1;
        rando.setText(Integer.toString(myRand));
    }

    public void depositTen(ActionEvent event) {

    }
}
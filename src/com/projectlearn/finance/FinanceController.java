package com.projectlearn.finance;

import com.projectlearn.login.LoginController;
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

public class FinanceController {

    @FXML
    private AnchorPane finance;

    @FXML
    private Label account;
    @FXML
    private Label balance;
    @FXML
    private Label displayAccountNumber;
    @FXML
    private Label displayName;
    @FXML
    private Label displayEmail;
    @FXML
    private Label displayID;
    @FXML
    private Label displayStatus;
    @FXML
    private Label setAccountNumber;
    @FXML
    private Label setName;
    @FXML
    private Label setEmail;
    @FXML
    private Label setID;
    @FXML
    private Label setStatus;

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
    @FXML
    public void welcome () {
        int currentAccount = LoginController.currentAccount;
            account.setText("Welcome " + AccountList.getAccount(currentAccount).getName() + "!");
            balance.setText("Your balance is: " + AccountList.getAccount(currentAccount).getBalance());

    }

    //deposit ActionHandler
    @FXML
    public void deposit(ActionEvent event) {
        int accountID = Integer.parseInt(accountNum.getText());
        System.out.println(accountID);
        int depositAmount = Integer.parseInt(amount.getText());
        System.out.println(depositAmount);
        balance.setText("Your balance is: " + AccountList.getAccount(accountID).deposit(depositAmount));
    }

    public void withdraw(ActionEvent event) {
        int accountID = Integer.parseInt(accountNum.getText());
        System.out.println(accountID);
        int withdrawValue = Integer.parseInt(withdrawAmount.getText());
        System.out.println(withdrawAmount);
        balance.setText("Your balance is: " + AccountList.getAccount(accountID).withdraw(withdrawValue));
    }


    public void newAccount (ActionEvent event) throws IOException{
                Parent newAccountParent = FXMLLoader.load(getClass().getResource("newAccount.fxml"));
                Scene newAccountScene = new Scene(newAccountParent);

                Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

                root.setScene(newAccountScene);
                root.show();

    }


}

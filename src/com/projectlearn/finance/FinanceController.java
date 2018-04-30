/*

package com.projectlearn.finance;

import com.projectlearn.login.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FinanceController implements Initializable{

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
    private Button logOut;

    @FXML
    private TextField amount;
    @FXML
    private TextField withdrawAmount;

    //Displays all of the account information
    @FXML
    public void accountInfo (int accountNum) {
        setAccountNumber.setText(Integer.toString(AccountList.getAccount(accountNum).getAccountNum()));
        setName.setText(AccountList.getAccount(accountNum).getName());
        setEmail.setText(AccountList.getAccount(accountNum).getEmail());
        setID.setText(Integer.toString(AccountList.getAccount(accountNum).getAccountID()));
        setStatus.setText(AccountList.getAccount(accountNum).getAccountType());
        account.setText("Welcome " + AccountList.getAccount(accountNum).getName() + "!");
        balance.setText("Your balance is: " + AccountList.getAccount(accountNum).getBalance());
    }

    public void initialize (URL url, ResourceBundle rb) {
        System.out.println(LoginController.currentAccount);
        accountInfo(LoginController.currentAccount);
    }

    //deposit ActionHandler
    @FXML
    public void deposit(ActionEvent event) {
        int accountID = LoginController.currentAccount;
        System.out.println(accountID);
        int depositAmount = Integer.parseInt(amount.getText());
        System.out.println(depositAmount);
        balance.setText("Your balance is: " + AccountList.getAccount(accountID).deposit(depositAmount));
    }

    public void withdraw(ActionEvent event) {
        int accountID = LoginController.currentAccount;
        System.out.println(accountID);
        int withdrawValue = Integer.parseInt(withdrawAmount.getText());
        System.out.println(withdrawAmount);
        balance.setText("Your balance is: " + AccountList.getAccount(accountID).withdraw(withdrawValue));
    }

    public void logOut(ActionEvent event) throws Exception{
        Parent logOut = FXMLLoader.load(getClass().getResource("/com/projectlearn/login/login.fxml"));
        Scene logOutScene = new Scene(logOut);

        Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

        root.setScene(logOutScene);
        root.show();
    }


}

*/
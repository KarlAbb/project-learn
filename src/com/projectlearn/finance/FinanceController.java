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

    //Main container
    @FXML
    private AnchorPane finance;

    @FXML
    private Label account;
    @FXML
    private Label balance;
    //These are all informational labels that do not change with each account
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
    //These are all informational labels that do change with each account to display information about it
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
    private Label warning;

    //These buttons deposit and withdraw the entered amount
    @FXML
    private Button deposit;
    @FXML
    private Button withdraw;
    //This button returns to the login scene
    @FXML
    private Button logOut;

    //This textfield contains the amount that should be deposited into an account
    @FXML
    private TextField amount;
    //This textfield contains the amount that should be withdrawn from an account
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
        if(!AccountList.getAccount(LoginController.currentAccount).getPerms().contains(Permissions.canDeposit)) {
            deposit.setDisable(true);
        }
        System.out.println(LoginController.currentAccount);
        accountInfo(LoginController.currentAccount);
    }

    //deposit ActionHandler
    @FXML
    public void deposit(ActionEvent event) {
        int accountID = LoginController.currentAccount;
        if(AccountList.getAccount(accountID).getPerms().contains(Permissions.canDeposit)) {
            System.out.println(accountID);
            int depositAmount = Integer.parseInt(amount.getText());
            System.out.println(depositAmount);
            balance.setText("Your balance is: " + AccountList.getAccount(accountID).deposit(depositAmount));
        }

        else {
            noPermission();
        }
    }

    //withdraw ActionHandler
    @FXML
    public void withdraw(ActionEvent event) {
        int accountID = LoginController.currentAccount;
        if(AccountList.getAccount(accountID).getPerms().contains(Permissions.canWithdraw)) {
            System.out.println(accountID);
            int withdrawValue = Integer.parseInt(withdrawAmount.getText());
            System.out.println(withdrawAmount);
            warning.setText("Your balance is: " + AccountList.getAccount(accountID).withdraw(withdrawValue));
        }

        else {
            noPermission();
        }
    }

    //Log out ActionHandler
    public void logOut(ActionEvent event) throws Exception{
        //Changes scene back to login screen
        Parent logOut = FXMLLoader.load(getClass().getResource("/com/projectlearn/login/login.fxml"));
        Scene logOutScene = new Scene(logOut);

        Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

        root.setScene(logOutScene);
        root.show();
    }

    public void noPermission() {
        warning.setText("You don't have permission to do this! Please contact an administrator if you believe that this is a mistake!");
    }

    public boolean enabledPerms() {
        return false;
    }


}

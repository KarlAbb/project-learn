package com.projectlearn.finance.gui;

import com.projectlearn.finance.logic.Account;
import com.projectlearn.finance.logic.AccountManager;
import com.projectlearn.finance.logic.Permissions;
import com.projectlearn.login.gui.LoginController;
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

import java.util.Set;

public class FinanceAdminController {

    private AccountManager accountManager;

    private Account currentAccount;

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
    //Changes to scene that shows all accounts
    @FXML
    private Button accounts;

    //This textfield contains the amount that should be deposited into an account
    @FXML
    private TextField amount;
    //This textfield contains the amount that should be withdrawn from an account
    @FXML
    private TextField withdrawAmount;

    private int accountNum;

    //Displays all of the account information
    @FXML
    public void accountInfo () {
        setAccountNumber.setText(Integer.toString(accountNum));
        setName.setText(currentAccount.getName());
        setEmail.setText(currentAccount.getEmail());
        setID.setText(Integer.toString(currentAccount.getAccountID()));
        setStatus.setText(currentAccount.getAccountType());
        account.setText("Welcome " + currentAccount.getName() + "!");
        balance.setText("Your balance is: " + currentAccount.getBalance());
        enabledPerms(currentAccount.getPerms());
    }


    //deposit ActionHandler
    @FXML
    public void deposit(ActionEvent event) {
        if(currentAccount.getPerms().contains(Permissions.CAN_DEPOSIT)) {
            System.out.println(accountNum);
            int depositAmount = Integer.parseInt(amount.getText());
            System.out.println(depositAmount);
            currentAccount.deposit(depositAmount);
            balance.setText("Your balance is: " + currentAccount.getBalance());
        }

        else {
            noPermission();
        }
    }

    //withdraw ActionHandler
    @FXML
    public void withdraw(ActionEvent event) {
        if(currentAccount.getPerms().contains(Permissions.CAN_WITHDRAW)) {
            System.out.println(accountNum);
            int withdrawValue = Integer.parseInt(withdrawAmount.getText());
            System.out.println(withdrawAmount);
            currentAccount.withdraw(withdrawValue);
            balance.setText("Your balance is: " + currentAccount.getBalance());
        }

        else {
            noPermission();
        }
    }

    //Log out ActionHandler
    public void logOut(ActionEvent event) throws Exception{

        //Changes scene back to login screen
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/projectlearn/login/gui/login.fxml"));

        Parent roots = fxmlLoader.load();
        LoginController loginController = fxmlLoader.<LoginController>getController();
        loginController.setAccountManager(accountManager);

        Scene scene = new Scene(roots);

        Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

        scene.getStylesheets().add(getClass().getResource("/com/projectlearn/finance/gui/finance.css").toExternalForm());

        root.setScene(scene);
        root.setResizable(false);
        root.show();
    }

    public void noPermission() {
        warning.setText("You don't have permission to do this! Please contact an administrator if you believe that this is a mistake!");
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void currentAccount (Account currentAccount) {
        this.currentAccount = currentAccount;
        accountNum = currentAccount.getAccountNum();
    }

    public void enabledPerms(Set<Permissions> perms) {
        if(!perms.contains(Permissions.CAN_DEPOSIT)) {
            deposit.setDisable(true);
        }

        if(!perms.contains(Permissions.CAN_WITHDRAW)) {
            withdraw.setDisable(true);
        }
    }

    public void viewAccounts(ActionEvent event) throws Exception {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/projectlearn/finance/gui/accountsView.fxml"));

            Parent roots = fxmlLoader.load();
            AccountViewController accountViewController = fxmlLoader.<AccountViewController>getController();
            accountViewController.setAccountManager(accountManager);
            accountViewController.setCurrentAccount(currentAccount);
            accountViewController.setAccounts();

            Scene scene = new Scene(roots);

            Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

            root.setScene(scene);
            root.setResizable(false);
            root.show();
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }


}
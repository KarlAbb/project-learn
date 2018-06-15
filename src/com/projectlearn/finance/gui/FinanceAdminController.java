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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public class FinanceAdminController {

    private AccountManager accountManager;

    private Account currentAccount;

    private Collection<Account> accountList;
    private ArrayList<Account> accountLists;

    Alert warnings = new Alert(Alert.AlertType.CONFIRMATION);

    //Goes back to account screen
    @FXML
    private Button back;
    //allows user to edit a selected account
    @FXML
    private Button edit;
    //allows user to create a new account
    @FXML
    private Button newAccount;
    //deletes an account
    @FXML
    private Button delete;
    @FXML
    private Button done;

    //tableview
    @FXML
    private TableView<Account> accountsDis;
    //Displays account numbers
    @FXML
    private TableColumn<Account, String> accountNums;
    //Displays account balances
    @FXML
    private TableColumn<Account, String> accountBalance;
    //Displays account names
    @FXML
    private TableColumn<Account, String> name;
    //Displays account emails
    @FXML
    private TableColumn<Account, String> email;
    //Displays account IDs
    @FXML
    private TableColumn<Account, String> id;
    //Displays account types/perms
    @FXML
    private TableColumn<Account, String> type;

    @FXML
    private TabPane control;
    @FXML
    private Tab home;
    @FXML
    private Tab accounts1;

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
        root.centerOnScreen();
        root.setResizable(false);
        root.show();
    }

    public void noPermission() {
        warning.setText("You don't have permission to do this! Please contact an administrator if you believe that this is a mistake!");
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
            root.centerOnScreen();
            root.setResizable(false);
            root.show();
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }


    //Populates the TableView
    @FXML
    public void setAccounts () {
        done.setDisable(true);
        accountList = accountManager.getList().values();
        accountLists = new ArrayList<Account>(accountList);
        accountBalance.setCellValueFactory(new PropertyValueFactory<Account, String>("balance"));
        accountNums.setCellValueFactory(new PropertyValueFactory<Account, String>("accountNum"));
        name.setCellValueFactory(new PropertyValueFactory<Account, String>("name"));
        email.setCellValueFactory(new PropertyValueFactory<Account, String>("email"));
        id.setCellValueFactory(new PropertyValueFactory<Account, String>("accountID"));
        type.setCellValueFactory(new PropertyValueFactory<Account, String>("accountType"));
        for (int i = 0; i <= accountLists.size() - 1; i ++) {
            accountsDis.getItems().addAll(accountLists.get(i));

        }
    }

    //Account deletion method
    @FXML
    public void delete(ActionEvent event) throws Exception {
        if(!(accountsDis.getSelectionModel().getSelectedItem() == null)) {
            warnings.setTitle("Warning");
            warnings.setContentText("Are you sure you want to delete this account?");
            Optional<ButtonType> result = warnings.showAndWait();
            if (result.get() == ButtonType.OK) {
                accountManager.getList().remove(accountsDis.getSelectionModel().getSelectedItem().getAccountNum());
                accountsDis.getItems().remove(accountsDis.getSelectionModel().getSelectedIndex());
            }
        }
    }

    //Edit account
    @FXML
    public void editAccount(ActionEvent event) throws Exception {
        accountsDis.setEditable(true);
        accountsDis.getSelectionModel().cellSelectionEnabledProperty().set(true);
        done.setDisable(false);
    }


    @FXML
    public void doneEdit(ActionEvent event) throws Exception {
        accountsDis.setEditable(false);
        done.setDisable(true);
    }


    //New account method
    @FXML
    public void newAccount(ActionEvent event) throws Exception {
        try {
            //loads newAccount.fmxl
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/projectlearn/finance/gui/newAccount.fxml"));

            Parent roots = fxmlLoader.load();
            NewAccountController newAccountController = fxmlLoader.<NewAccountController>getController();
            newAccountController.setAccountManager(accountManager);
            newAccountController.setCurrentAccount(currentAccount);

            Scene scene = new Scene(roots);

            Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

            root.setScene(scene);
            root.centerOnScreen();
            root.setResizable(false);
            root.show();
        }
        catch (Exception e) {

        }

    }



    //Goes back to account screen
    @FXML
    public void back(ActionEvent event) throws Exception{

        try {
            //loads financeAdmin.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/projectlearn/finance/gui/financeAdmin.fxml"));

            Parent roots = fxmlLoader.load();
            FinanceAdminController financeAdminController = fxmlLoader.<FinanceAdminController>getController();
            financeAdminController.setAccountManager(accountManager);
            financeAdminController.currentAccount(currentAccount);
            financeAdminController.accountInfo();


            Scene scene = new Scene(roots);

            Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

            scene.getStylesheets().add(getClass().getResource("/com/projectlearn/finance/gui/finance.css").toExternalForm());

            root.setScene(scene);
            root.setResizable(false);
            root.show();

        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Allows for an updated accountManager instance to be passed in
    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    //Passes in the logged in account
    public void setCurrentAccount(Account account) {
        this.currentAccount = account;
    }


}
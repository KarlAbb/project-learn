package com.projectlearn.finance.gui;

import com.projectlearn.finance.logic.Account;
import com.projectlearn.finance.logic.AccountManager;
import com.projectlearn.finance.logic.Permissions;
import com.projectlearn.login.gui.LoginController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.converter.DefaultStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public class FinanceAdminController implements Initializable {

    private AccountManager accountManager;

    private Account currentAccount;

    ObservableList<String> types = FXCollections.observableArrayList("Intern", "Employee", "Team Leader", "IT", "IT Manager", "Manager", "HR", "HR Manager", "Admin", "CEO");

    private Collection<Account> accountList;
    private ArrayList<Account> accountLists;

    Alert warnings = new Alert(Alert.AlertType.CONFIRMATION);
    Alert errors = new Alert(Alert.AlertType.ERROR);

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
    private TableColumn<Account, Integer> id;
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

    @FXML
    private Button logOutView;

    //This textfield contains the amount that should be deposited into an account
    @FXML
    private TextField amount;
    //This textfield contains the amount that should be withdrawn from an account
    @FXML
    private TextField withdrawAmount;

    private int accountNum;

    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {

    }

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

        DialogPane dialogPane = errors.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("finance.css").toExternalForm());
        dialogPane.getStyleClass().add("errors");
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
            if(currentAccount.getBalance() > withdrawValue) {
                currentAccount.withdraw(withdrawValue);
                balance.setText("Your balance is: " + currentAccount.getBalance());
            }
            else {
                displayError("You do not have enough funds!");
            }
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
        displayError("You don't have permission to do this! Please contact an administrator if you believe that this is a mistake!");
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


    //Populates the TableView
    @FXML
    public void setAccounts () {
        accountsDis.setEditable(true);
        done.setDisable(true);
        accountList = accountManager.getList().values();
        accountLists = new ArrayList<Account>(accountList);
        accountBalance.setCellValueFactory(new PropertyValueFactory<Account, String>("balance"));
        accountNums.setCellValueFactory(new PropertyValueFactory<Account, String>("accountNum"));
        name.setCellValueFactory(new PropertyValueFactory<Account, String>("name"));
        email.setCellValueFactory(new PropertyValueFactory<Account, String>("email"));
        id.setCellValueFactory(new PropertyValueFactory<Account, Integer>("accountID"));
        type.setCellValueFactory(new PropertyValueFactory<Account, String>("accountType"));
        for (int i = 0; i <= accountLists.size() - 1; i ++) {
            accountsDis.getItems().addAll(accountLists.get(i));

        }
        accountsDis.getSelectionModel().cellSelectionEnabledProperty().set(true);
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        email.setCellFactory(TextFieldTableCell.forTableColumn());
        type.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), types));
        id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    }

    //Account deletion method
    @FXML
    public void delete(ActionEvent event) throws Exception {
        if(!(accountsDis.getSelectionModel().getSelectedItem() == null)) {
            displayWarning("Warning", "Are you sure you want to delete this account?");
            Optional<ButtonType> result = warnings.showAndWait();
            if (result.get() == ButtonType.OK) {
                accountManager.getList().remove(accountsDis.getSelectionModel().getSelectedItem().getAccountNum());
                accountsDis.getItems().remove(accountsDis.getSelectionModel().getSelectedIndex());
            }
        }
    }

    //Edits account names
    @FXML
    public void editName(TableColumn.CellEditEvent<Account, String> event) throws Exception {
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        accountsDis.getSelectionModel().cellSelectionEnabledProperty().set(true);
        String newValue = event.getNewValue();
        TablePosition<Account, String> position = event.getTablePosition();

        int accountNum = accountsDis.getItems().get(position.getRow()).getAccountNum();
        Account account = accountManager.getAccount(accountNum);
        account.setName(newValue);
        accountManager.setAccounts(accountNum, account);

    }

    //Edits account emails
    @FXML
    public void editEmail(TableColumn.CellEditEvent<Account, String> event) throws Exception {
        email.setCellFactory(TextFieldTableCell.forTableColumn());
        accountsDis.getSelectionModel().cellSelectionEnabledProperty().set(true);
        String newValue = event.getNewValue();
        TablePosition<Account, String> position = event.getTablePosition();

        int accountNum = accountsDis.getItems().get(position.getRow()).getAccountNum();
        Account account = accountManager.getAccount(accountNum);
        account.setEmail(newValue);
        accountManager.setAccounts(accountNum, account);
    }

    @FXML
    public void editID(TableColumn.CellEditEvent<Account, Integer> event) throws IllegalArgumentException {
        int newValue = event.getNewValue();
        TablePosition<Account, Integer> position = event.getTablePosition();
        System.out.println(newValue);
        int accountNum = accountsDis.getItems().get(position.getRow()).getAccountNum();
        Account account = accountManager.getAccount(accountNum);
        account.setAccountID(newValue);
        accountManager.setAccounts(accountNum, account);
    }

    @FXML
    public void editType(TableColumn.CellEditEvent<Account, String> event) throws Exception {
        event.getNewValue();
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


    //Allows for an updated accountManager instance to be passed in
    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    //Passes in the logged in account
    public void setCurrentAccount(Account account) {
        this.currentAccount = account;
    }

    public TabPane getPane () {
        return control;
    }

    //displays a custom error pop up
    public void displayError (String warning) {
        errors.setTitle("Warning");
        errors.setContentText(warning);
        Optional<ButtonType> result = errors.showAndWait();
    }

    //displays a custom warning pop up
    public void displayWarning (String title, String warning) {
        warnings.setTitle(title);
        warnings.setContentText(warning);
        Optional<ButtonType> result = warnings.showAndWait();
    }


}
package com.projectlearn.finance.gui;

import com.projectlearn.finance.logic.Account;
import com.projectlearn.finance.logic.AccountManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;


public class AccountViewController {
    private AccountManager accountManager;
    private Account currentAccount;

    private Collection<Account> accountList;
    private ArrayList<Account> accountLists;

    Alert warning = new Alert(Alert.AlertType.CONFIRMATION);

    //Goes back to account screen
    @FXML
    private Button back;
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
    private TableView<Account> accounts;
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

    //Populates the TableView
    @FXML
    public void setAccounts () {
        done.setDisable(true);
        accountList = accountManager.getList().values();
        accountLists = new ArrayList<Account>(accountList);
        accountBalance.setCellValueFactory(new PropertyValueFactory<Account, String>("balance"));
        accountNums.setCellValueFactory(new PropertyValueFactory<Account, String>("accountNum"));
        name.setCellValueFactory(new PropertyValueFactory<Account, String>("name"));
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        email.setCellValueFactory(new PropertyValueFactory<Account, String>("email"));
        id.setCellValueFactory(new PropertyValueFactory<Account, String>("accountID"));
        type.setCellValueFactory(new PropertyValueFactory<Account, String>("accountType"));
        for (int i = 0; i <= accountLists.size() - 1; i ++) {
            accounts.getItems().addAll(accountLists.get(i));

        }

    }

    //Account deletion method
    @FXML
    public void delete(ActionEvent event) throws Exception {
        if(!(accounts.getSelectionModel().getSelectedItem() == null)) {
            warning.setTitle("Warning");
            warning.setContentText("Are you sure you want to delete this account?");
            Optional<ButtonType> result = warning.showAndWait();
            if (result.get() == ButtonType.OK) {
                accountManager.getList().remove(accounts.getSelectionModel().getSelectedItem().getAccountNum());
                accounts.getItems().remove(accounts.getSelectionModel().getSelectedIndex());
            }
        }
    }

    //Edit account
    @FXML
    public void editAccount(TableColumn.CellEditEvent cellEditEvent) {

        accounts.setEditable(true);
        Account account = accounts.getSelectionModel().getSelectedItem();
        account.setName(cellEditEvent.getNewValue().toString());
    }

    /*
    ActionEvent event) throws Exception {
        accounts.getSelectionModel().getSelectedIndex();
        accounts.getItems().get(accounts.getSelectionModel().getSelectedIndex());
        accounts.setEditable(true);
        accounts.getSelectionModel().cellSelectionEnabledProperty().set(true);
        done.setDisable(false);
     */


    @FXML
    public void edits(TableColumn.CellEditEvent cellEditEvent) {
        accounts.setEditable(true);
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        Account account = accounts.getSelectionModel().getSelectedItem();
        account.setName(cellEditEvent.getNewValue().toString());
    }

    @FXML
    public void doneEdit(ActionEvent event) throws Exception {
        accounts.getSelectionModel().getSelectedIndex();
        accounts.getItems().get(accounts.getSelectionModel().getSelectedIndex());
        accounts.setEditable(false);
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

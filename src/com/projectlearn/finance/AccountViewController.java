package com.projectlearn.finance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


public class AccountViewController {
    private AccountManager accountManager;
    private Account currentAccount;

    private Collection<Account> accountList;
    private ArrayList<Account> accountLists;

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
        accountList = accountManager.getList().values();
        accountLists = new ArrayList<Account>(accountList);
        accountBalance.setCellValueFactory(new PropertyValueFactory<Account, String>("balance"));
        accountNums.setCellValueFactory(new PropertyValueFactory<Account, String>("accountNum"));
        name.setCellValueFactory(new PropertyValueFactory<Account, String>("name"));
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

    }

    //New account method
    @FXML
    public void newAccount(ActionEvent event) throws Exception {
        try {
            //loads newAccount.fmxl
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/projectlearn/finance/newAccount.fxml"));

            Parent roots = fxmlLoader.load();
            NewAccountController newAccountController = fxmlLoader.<NewAccountController>getController();
            newAccountController.setAccountManager(accountManager);
            newAccountController.setCurrentAccount(currentAccount);

            Scene scene = new Scene(roots);

            Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

            root.setScene(scene);
            root.setResizable(false);
            root.show();
        }
        catch (Exception e) {

        }

    }

    @FXML
    public void deleteAccount(ActionEvent event) throws Exception{

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            if(!(accounts.getSelectionModel().getSelectedItem() == null)) {
                accountManager.getList().remove(accounts.getSelectionModel().getSelectedItem().getAccountNum());
                setAccounts();
            }
        } else {
            alert.close();
        }


    }


    //Goes back to account screen
    @FXML
    public void back(ActionEvent event) throws Exception{

        try {
            //loads financeAdmin.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/projectlearn/finance/financeAdmin.fxml"));

            Parent roots = fxmlLoader.load();
            FinanceAdminController financeAdminController = fxmlLoader.<FinanceAdminController>getController();
            financeAdminController.setAccountManager(accountManager);
            financeAdminController.currentAccount(currentAccount);
            financeAdminController.accountInfo();


            Scene scene = new Scene(roots);

            Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

            scene.getStylesheets().add(getClass().getResource("/com/projectlearn/finance/finance.css").toExternalForm());

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

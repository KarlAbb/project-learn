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

    @FXML
    private Button back;
    @FXML
    private Button edit;
    @FXML
    private Button newAccount;
    @FXML
    private Button delete;

    @FXML
    private TableView<Account> accounts;
    @FXML
    private TableColumn<Account, String> accountNums;
    @FXML
    private TableColumn<Account, String> accountBalance;
    @FXML
    private TableColumn<Account, String> name;
    @FXML
    private TableColumn<Account, String> email;
    @FXML
    private TableColumn<Account, String> id;
    @FXML
    private TableColumn<Account, String> type;

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

    @FXML
    public void newAccount(ActionEvent event) throws Exception {
        try {
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


    @FXML
    public void back(ActionEvent event) throws Exception{

        try {
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

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void setCurrentAccount(Account account) {
        this.currentAccount = account;
    }
}

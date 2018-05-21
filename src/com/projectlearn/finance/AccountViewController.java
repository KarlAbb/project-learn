package com.projectlearn.finance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class AccountViewController {
    AccountManager accountManager;

    private Collection<Account> accountList;
    private ArrayList<Account> accountLists;

    @FXML
    private Button back;

    @FXML
    private TableView<Account> accounts;
    @FXML
    private TableColumn<Account, String> accountNums;
    @FXML
    private TableColumn<Account, String> accountBalance;

    @FXML
    public void setAccounts () {
        accountList = accountManager.getList().values();
        accountLists = new ArrayList<Account>(accountList);
        accountBalance.setCellValueFactory(new PropertyValueFactory<Account, String>("balance"));
        accountNums.setCellValueFactory(new PropertyValueFactory<Account, String>("accountNum"));
        for (int i = 0; i <= accountLists.size() - 1; i ++) {
            accounts.getItems().addAll(accountLists.get(i));

        }
    }


    @FXML
    public void back(ActionEvent event) throws Exception{

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/projectlearn/finance/financeAdmin.fxml"));

            Parent roots = fxmlLoader.load();
            FinanceAdminController financeAdminController = fxmlLoader.<FinanceAdminController>getController();
            financeAdminController.setAccountManager(accountManager);

            Scene scene = new Scene(roots);

            scene.getStylesheets().add(getClass().getResource("/com/projectlearn/finance/finance.css").toExternalForm());

            Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

            root.setScene(scene);
            root.setResizable(false);
            root.show();
        }

        catch (Exception e) {

        }
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }
}

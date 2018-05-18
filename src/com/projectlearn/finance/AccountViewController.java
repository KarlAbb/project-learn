package com.projectlearn.finance;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.text.TableView;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AccountViewController {
    AccountManager accountManager;

    @FXML
    private Button back;

    @FXML
    private TableView accounts;

    public void back(ActionEvent event) throws Exception{

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/projectlearn/finance/financeAdmin.fxml"));

            Parent roots = fxmlLoader.load();
            FinanceController financeController = fxmlLoader.<FinanceController>getController();
            financeController.setAccountManager(accountManager);

            Scene scene = new Scene(roots);

            Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

            root.setScene(scene);
            root.setResizable(false);
            root.show();
        }

        catch (Exception e) {

        }
    }
}

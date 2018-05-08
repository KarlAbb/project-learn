

package com.projectlearn.login;

import com.projectlearn.finance.logic.EmployeeList;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginController {

    public static int currentAccount = 0;

    @FXML
    private Label accountLabel;

    @FXML
    private TextField numTextField;

    @FXML
    private Label passwordLabel;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private Button newAccountBtn;

    @FXML
    private Text logo;

    @FXML
    private Text loginText;

    @FXML


    //check login
    private loginProcessor loginprocessor;

    public LoginController() {
        loginprocessor = new loginProcessor();
    }

    @FXML
    public void cancelBtn_Click(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void newAccount (ActionEvent event) throws IOException { Parent newAccountParent = FXMLLoader.load(getClass().getResource("/com/projectlearn/finance/newAccount.fxml"));
        Scene newAccountScene = new Scene(newAccountParent);

        Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

        root.setScene(newAccountScene);
        root.show();

    }


    @FXML
    public void loginBtn_Click(ActionEvent event) throws IOException {


            if (EmployeeList.checkLoginInfo(Integer.parseInt(numTextField.getText()),passwordField.getText())) {
            loginText.setFill(Color.GREEN);
                loginText.setText("welcome");

            } else {
                loginText.setFill(Color.RED);
                loginText.setText("Incorrect email or password");
            }


    }
}

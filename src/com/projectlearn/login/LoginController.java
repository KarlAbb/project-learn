package com.projectlearn.login;

import com.projectlearn.finance.Account;
import com.projectlearn.finance.AccountList;
import com.projectlearn.finance.FinanceController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController{

    public static int currentAccount = 0;

    //logo
    @FXML
    private ImageView logoImage;

    //Account number prompt label
    @FXML
    private Label accountLabel;

    //Account number textfield
    @FXML
    private TextField numTextField;

    //Account password prompt label
    @FXML
    private Label passwordLabel;

    //Account password textfield
    @FXML
    private PasswordField passwordField;

    //Cancels and exits the application
    @FXML
    private Button cancelBtn;

    //Checks login info and changes to account scene
    @FXML
    private Button loginBtn;

    //Changes to new account scene
    @FXML
    private Button newAccountBtn;

    @FXML
    private Text loginText;

    //Cancels and exits application
    @FXML
    public void cancelBtn_Click(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    //ActionHandler to new account scene
    @FXML
    public void newAccount (ActionEvent event) throws IOException { Parent newAccountParent = FXMLLoader.load(getClass().getResource("/com/projectlearn/finance/newAccount.fxml"));
        Scene newAccountScene = new Scene(newAccountParent);

        Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

        root.setScene(newAccountScene);
        root.show();

    }

    //ActionHandler to main scene if login info is correct
    @FXML
    public void loginBtn_Click(ActionEvent event) throws IOException {

        try {
            //checks to see if login info is correct
            if (AccountList.getAccount(Integer.parseInt(numTextField.getText())).getAccountPassword().equals(passwordField.getText())) {
                //sets the account number entered by a user to an int so that the main scene knows what account to display
                currentAccount = Integer.parseInt(numTextField.getText());

                //loads up the main scene
                Parent mainAccount = FXMLLoader.load(getClass().getResource("/com/projectlearn/finance/finance.fxml"));
                Scene mainAccountScene = new Scene(mainAccount);
                mainAccountScene.getStylesheets().add(getClass().getResource("/com/projectlearn/finance/finance.css").toExternalForm());

                Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

                root.setScene(mainAccountScene);
                root.show();

            }
            //login incorrect actions
            else {
                loginText.setFill(Color.RED);
                loginText.setText("Incorrect email or password");
            }
        }
        //catchs exceptions i.e letters instead of numbers for the account number entered
        catch(Exception e) {
            loginText.setFill(Color.GREEN);
            loginText.setText("Oops! Something went wrong! Please try again!");
            System.out.println(e.getCause() + " " + e.getMessage() + " " + e.getStackTrace());
        }

    }
}

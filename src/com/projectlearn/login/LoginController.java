package com.projectlearn.login;

import com.projectlearn.finance.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;


public class LoginController{
    private AccountManager accountManager;

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

    int num1 = 1234;
    int balance1 = 10;
    Account stefan = new Account(num1, balance1, "Stefan", "sell488sftoday@gmail.com", "1234", 12, "Owner", Main.admin);

    Account currentAccount;





    //Cancels and exits application
    @FXML
    public void cancelBtn_Click(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    //ActionHandler to new account scene
    @FXML
    public void newAccount (ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/projectlearn/finance/newAccount.fxml"));

        Parent roots = fxmlLoader.load();
        NewAccountController newAccountController = fxmlLoader.<NewAccountController>getController();
        newAccountController.setAccountManager(accountManager);

        Scene scene = new Scene(roots);

        Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

        root.setScene(scene);
        root.setResizable(false);
        root.show();

    }

    //ActionHandler to main scene if login info is correct
    @FXML
    public void loginBtn_Click(ActionEvent event) throws IOException {

        try {
            int num1 = 1234;
            int balance1 = 10;
            Account stefan = new Account(num1, balance1, "Stefan", "sell488sftoday@gmail.com", "1234", 12, "Owner", Main.admin);
            accountManager.setAccounts(num1, stefan);

            currentAccount = accountManager.getAccount(Integer.parseInt(numTextField.getText()));
            int accountNum = currentAccount.getAccountNum();
            String accountPassword = currentAccount.getAccountPassword();
            String inputPassword  = passwordField.getText();

            //checks to see if login info is correct
            if (checkLogin(accountPassword, inputPassword)) {

                //loads up the main scene
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/projectlearn/finance/finance.fxml"));

                Parent roots = fxmlLoader.load();
                FinanceController financeController = fxmlLoader.<FinanceController>getController();
                financeController.setAccountManager(accountManager);
                financeController.accountInfo(Integer.parseInt(numTextField.getText()));

                Scene scene = new Scene(roots);

                Stage root = (Stage) ((Node) event.getSource()).getScene().getWindow();

                scene.getStylesheets().add(getClass().getResource("/com/projectlearn/finance/finance.css").toExternalForm());

                root.setScene(scene);
                root.setResizable(false);
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
            int num1 = 1234;
            int balance1 = 10;
            Account stefan = new Account(num1, balance1, "Stefan", "sell488sftoday@gmail.com", "1234", 12, "Owner", Main.admin);
            accountManager.setAccounts(num1, stefan);

            loginText.setFill(Color.GREEN);
            loginText.setText("Oops! Something went wrong! Please try again!");
            System.out.println(e.getCause() + " " + e.getMessage() + " " + e.getStackTrace());
            e.printStackTrace();
        }

        finally {
            int num1 = 1234;
            int balance1 = 10;
            Account stefan = new Account(num1, balance1, "Stefan", "sell488sftoday@gmail.com", "1234", 12, "Owner", Main.admin);
            accountManager.setAccounts(num1, stefan);
        }

    }

    /*public void setAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }*/

    public boolean checkLogin(String accountPassword, String password) {
        if((accountPassword.equals(password))) {
            return true;
        }
        else {return false;}
    }

    public void permissionList(HashMap<String, Set<Permissions>> permissionList) {

    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }
}



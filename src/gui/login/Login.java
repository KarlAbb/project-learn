package gui.login;

import com.projectlearn.business.finance.Account;
import com.projectlearn.business.finance.AccountList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login extends Application {
    public  Stage stage;
    public Scene mainAccountScene;

    public static void main(String[] args) {
        AccountList accounts = new AccountList();
        int num = 1234;
        int balance = 10;
        String name = "hello";
        Account stefan = new Account(num, balance, "Stefan", "sell488sftoday@gmail.com", "1234", 12, "Owner");
        accounts.setAccounts(num, stefan);

        launch(args);
    }




    //Buttons
    Button btnLogin;
    Button btnCancel;
    TextField emailField;
    PasswordField passwordField;
    private String name;
    private String password;


    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/gui/login/login.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}

package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginController {

    @FXML
    private Label emailLabel;

    @FXML
    private TextField emailTextField;

    @FXML
    private Label passwordLabel;

    @FXML
    private PasswordField emailPasswordField;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private Text logo;

    @FXML
    private Text loginText;

    @FXML


    //check login
    private loginProcessor loginprocessor;

    public LoginController() {
        loginprocessor = new loginProcessor(); //gives an error
    }

    public void cancelBtn_Click(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();

    }


    @FXML
    public void loginBtn_Click(ActionEvent event) {

        if (loginprocessor.checkLogin(emailTextField.getText(), emailPasswordField.getText())) {
            loginText.setText("Logged in");
        } else {
            loginText.setFill(Color.RED);
            loginText.setText("Incorrect email or password");
        }

    }

}

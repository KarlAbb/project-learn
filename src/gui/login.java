package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class login extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    //Buttons
    Button btnLogin;
    Button btnCancel;
    TextField emailField;
    PasswordField passwordField;
    private String name;
    private String password;
    Stage stage;

    @Override public void start(Stage primaryStage){

    //initializing

        // buttons and setting them up
        btnLogin = new Button();
        btnLogin.setText("Login");
        btnLogin.setPrefSize(100,4);
       // btnLogin.onActionProperty(e -> btnLogin_Click());

        btnCancel = new Button();
        btnCancel.setText("Cancel");
        btnCancel.setPrefSize(100,4);
        btnCancel.setOnAction(e -> btnCancel_Click());

        //Fields
        emailField = new TextField();
        emailField.setPrefWidth(10);
        emailField.setPromptText("Enter your email");

        passwordField = new PasswordField();
        passwordField.setPrefWidth(10);
        passwordField.setPromptText("Enter your password");



        //Hbox for the buttons
        HBox ButtonHbox = new HBox(40,btnLogin,btnCancel);
        ButtonHbox.setAlignment(Pos.CENTER);


        //Header image
        ImageView headImage = new ImageView("/gui/login.png");
        headImage.setFitHeight(150);
        headImage.setFitWidth(150);



                    //need to figure a better way to put the img in the center
        VBox imgbox = new VBox(headImage);
        imgbox.setAlignment(Pos.TOP_CENTER);
        imgbox.setPadding(new Insets(10,0,0,0));


        //Vbox for the textfield & passwordfield
        VBox vBox = new VBox(20, emailField,passwordField,ButtonHbox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10));


        //Main Pane
        BorderPane mainPane = new BorderPane();
        mainPane.setTop(imgbox);
        mainPane.setCenter(vBox);


        //Scene
        Scene scene = new Scene(mainPane,300,450);


        //Finalizing
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.setResizable(false);
        primaryStage.show();
        stage = primaryStage;


    }

    public void btnCancel_Click(){
        stage.close();
    }
}

package com.projectlearn.business;

import com.projectlearn.business.builders.FinanceAccountBuilder;
import com.projectlearn.business.finance.account.AbstractFinancies;
import com.projectlearn.business.finance.account.Account;
import com.projectlearn.business.builders.AccountBuilder;
import com.projectlearn.business.finance.account.AccountType;
import com.projectlearn.business.finance.account.types.CEO;
import com.projectlearn.business.finance.account.types.FinancialAccount;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.UUID;

public class Main extends Application{

    public static void main(String... args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Click me");
        btn.setOnAction(e -> System.out.println("Hello!!!"));

        StackPane root = new StackPane();
        root.getChildren().addAll(btn);

        Scene scene = new Scene(root, 500, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public void doStuff(){
        // Demonstration of Account builder.
        Account account = new AccountBuilder()
                .withName("Josh")
                .withPassword("123")
                .withID(UUID.randomUUID())
                .withAccountType(AccountType.CEO)
                .finishAccount();
        // Demonstration of FinanceAccount builder.
        AbstractFinancies financiesAccount = new FinanceAccountBuilder()
                .setAccount(account)
                .setSalary(20)
                .setBalance(50)
                .build();

        // Now possibly have a structure like Map<Account, AbstractFinancies> ? So I could keep them coupled together?
    }
}

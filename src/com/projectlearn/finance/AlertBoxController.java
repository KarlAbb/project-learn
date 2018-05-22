package com.projectlearn.finance;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBoxController {

    @FXML
    private Label warning;

    @FXML
    private Button yes;
    @FXML
    private Button cancel;

    public void display(String warning) {
        this.warning.setText(warning);
    }
}


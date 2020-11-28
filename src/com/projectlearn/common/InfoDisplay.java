package com.projectlearn.common;
/* created by User on 8/13/2018 */

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class InfoDisplay {

    private static Alert warnings = new Alert(Alert.AlertType.CONFIRMATION);
    private static Alert errors = new Alert(Alert.AlertType.ERROR);

    public InfoDisplay() {
        errors.setTitle("Warning");
    }

    public static void displayWarning (String title, String warning) {
        warnings.setTitle(title);
        warnings.setContentText(warning);
        Optional<ButtonType> result = warnings.showAndWait();
    }

    public static void displayError (String warning) {
        errors.setContentText(warning);
    }
}

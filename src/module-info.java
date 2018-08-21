open module com.projectlearn {
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.media;
    requires javafx.fxml;
    requires javafx.deploy;
    requires javafx.swing;
    requires javafx.web;

    exports com.projectlearn;
    exports com.projectlearn.login.gui;
    exports com.projectlearn.finance.gui;
    exports com.projectlearn.finance.logic;
}
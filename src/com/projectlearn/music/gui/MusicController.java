package com.projectlearn.music.gui;

import com.projectlearn.finance.logic.Account;
import com.projectlearn.music.Music;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class MusicController {
    private Collection<Music> song;
    private ArrayList<Music> song1;

    @FXML
    private Button start;
    @FXML
    private Button next;
    @FXML
    private Button back;
    @FXML
    private Button quit;

    //tableview
    @FXML
    private TableView<Music> songs;
    //Displays song names
    @FXML
    private TableColumn<Music, String> songName;
    /*//Displays account balances
    @FXML
    private TableColumn<Account, String> accountBalance;
    //Displays account names
    @FXML
    private TableColumn<Account, String> name;
    //Displays account emails
    @FXML
    private TableColumn<Account, String> email;
    //Displays account IDs
    @FXML
    private TableColumn<Account, String> id;
    //Displays account types/perms
    @FXML
    private TableColumn<Account, String> type;*/

    public void setSongs() {
        Music music = new Music();
        songs = new ArrayList<Music>(music.getFolder());
        songName.setCellValueFactory(new PropertyValueFactory<Music, String>("folder"));
        for(int i = 0; i <= music.getFolder().size() - 1; i ++)
    }
}

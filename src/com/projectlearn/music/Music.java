package com.projectlearn.music;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class Music {
    private MediaPlayer mediaPlayer;

    public void playSomething() throws Exception{
        File folder = new File("src/com/projectlearn/resources/songs");
        File[] listOfFiles = folder.listFiles();
        Random random = new Random();
        int song = random.nextInt(listOfFiles.length - 1);
        Media startUpSound = new Media(new File(listOfFiles [song].getPath()).toURI().toString());
        mediaPlayer = new MediaPlayer(startUpSound);
        mediaPlayer.play();

    }
}

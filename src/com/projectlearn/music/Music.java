package com.projectlearn.music;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Music {
    private MediaPlayer mediaPlayer;
    private ArrayList<String> names = new ArrayList<>();

    File folder = new File("src/com/projectlearn/resources/songs");
    File[] listOfFiles = folder.listFiles();
    Random random = new Random();

    public void playSomething() throws Exception{
        int song = random.nextInt(listOfFiles.length - 1);
        Media startUpSound = new Media(new File(listOfFiles [song].getPath()).toURI().toString());
        mediaPlayer = new MediaPlayer(startUpSound);
        mediaPlayer.play();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }

    }

    public ArrayList<String> getSongs() {
        for (int i = 0; i < listOfFiles.length; i ++) {
            names.add(listOfFiles [i].getName());
        }
        return names;
    }

}

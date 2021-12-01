package com.company.Application;

import com.company.Hangman.Hangman;
import com.company.Login.LoginValidation;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class ApplicationOverview {

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {
        LoginValidation loginValidation = new LoginValidation();
        loginValidation.flockingIntoSocialFolks();
        String username = loginValidation.getUsername();
        System.out.println("username: " + username);
        Hangman hangman = new Hangman(username);
        hangman.gameOverview();
       // System.out.println("username data store after: " + loginValidation.getUsernamesData());

       /* Hangman hangman = new Hangman(username);
        hangman.gameOverview();*/
    }
}

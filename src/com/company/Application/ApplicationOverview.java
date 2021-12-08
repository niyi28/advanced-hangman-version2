package com.company.Application;

import com.company.Hangman.GameManager.Hangman;
import com.company.Login.LoginValidation;

/*import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;*/

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ApplicationOverview {

    public static void main(String[] args) throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException {
        LoginValidation loginValidation = new LoginValidation();
        loginValidation.flockingIntoSocialFolks();
        String username = loginValidation.getUsername();
        String password = loginValidation.getPassword();
        System.out.println("username: " + username);
        Hangman hangman = new Hangman(username, password);
        hangman.gameOverview();



        /*http://localhost:8081/game.html*/
       // System.out.println("username data store after: " + loginValidation.getUsernamesData());

       /* Hangman hangman = new Hangman(username);
        hangman.gameOverview();*/

        /*/createGame?playerName=Oleniyi*/

        /*/createGame?playerName=Oleniyi&language=english*/

    }
}

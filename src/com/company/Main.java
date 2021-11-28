package com.company;

import com.company.Hangman.Hangman;
import com.company.Login.LoginValidation;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        LoginValidation loginValidation = new LoginValidation();
        loginValidation.flockingIntoSocialFolks();
        String username = loginValidation.getUsername();
        System.out.println("username: " + username);
        Hangman hangman = new Hangman(username);
        hangman.gameOverview();
    }
}

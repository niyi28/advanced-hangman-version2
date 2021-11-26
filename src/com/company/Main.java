package com.company;

import com.company.Hangman.Hangman;
import com.company.Login.LoginValidation;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LoginValidation loginValidation = new LoginValidation();
        loginValidation.flockingIntoSocialFolks();
        String username = loginValidation.getUsername();
        System.out.println("username: " + username);
        Hangman hangman = new Hangman(username);
        hangman.gameOverview();
    }
}

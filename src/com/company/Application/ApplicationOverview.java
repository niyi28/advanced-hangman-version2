package com.company.Application;

import com.company.Hangman.Hangman;
import com.company.Login.LoginValidation;

public class ApplicationOverview {

    public static void main(String[] args) {
        LoginValidation loginValidation = new LoginValidation();
        System.out.println("username data store before: " + loginValidation.getUsernamesData());
        loginValidation.flockingIntoSocialFolks();
        String username = loginValidation.getUsername();
        System.out.println("username: " + username);
        System.out.println("username data store after: " + loginValidation.getUsernamesData());
        /*ncxrdklr4ore94degf*/
        /*Hangman hangman = new Hangman(username);
        hangman.gameOverview();*/
    }
}
package com.company.Hangman;

import java.util.Scanner;

public class ScannerInitiator{

    Scanner scanner = new Scanner(System.in);

    public ScannerInitiator(){
        this.scanner = scanner;
    }

    public int getScannerInt(){
        int integer = scanner.nextInt();
        return integer;
    }

    public String getScannerString(){
        String string = scanner.nextLine();
        return string;
    }

}
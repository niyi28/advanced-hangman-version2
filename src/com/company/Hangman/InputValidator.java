package com.company.Hangman;// import java.util.Scanner;
import java.util.ArrayList;

public class InputValidator {

    // Scanner scanner  = new Scanner(System.in);
    ArrayList <String> addedLetters = new ArrayList <> ();
    ScannerInitiator scannerInitiator = new ScannerInitiator();

    public InputValidator (){
        this.scannerInitiator = scannerInitiator;
    }

    public String getValidGuess(){
        String guessedLetter = getGuess();
        while( !isValidLength(guessedLetter) || !isValidLetter(guessedLetter) || !isNewLetter(guessedLetter)){
            System.out.println("NOT valid! Its either you put in an invalid letter or repeating an already used letter ");
            guessedLetter = scannerInitiator.getScannerString();
        }
        return guessedLetter;
    }

    private String getGuess(){
        System.out.print("Guess: ");
        String guessedLetter = scannerInitiator.getScannerString();
        return guessedLetter;
    }

    private boolean isValidLength (String guessedLetter){
        return !(guessedLetter.length() > 1);
    }

    private boolean isValidLetter (String guessedLetter){
        return Character.isLetter(guessedLetter.charAt(0));
    }

    private boolean isNewLetter (String guessedLetter){
        boolean isLetterExisting = addedLetters.contains(guessedLetter);
        addedLetters.add(guessedLetter);
        return !isLetterExisting;
    }
}
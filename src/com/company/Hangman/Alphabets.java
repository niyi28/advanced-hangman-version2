package com.company.Hangman;

import java.util.ArrayList;

public class Alphabets{
    public static void printRemainingAlphabets(char guessedLetter, ArrayList <Character> remainingAlphabet){
        int index;
        for(char letter = 'A'; letter <= 'Z'; ++letter){
            if(remainingAlphabet.contains(guessedLetter)){
                index = remainingAlphabet.indexOf(guessedLetter);

                char removedLetter = remainingAlphabet.remove(index);
                System.out.println("Remaining Letters: " + remainingAlphabet);
                break;
            }else{
                System.out.println("You already used this letter. Try a new one from the following list: " + remainingAlphabet);
                break;

            }
        }
    }


    public static ArrayList<Character> getAlphabet(){

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(char letter = 'A'; letter <= 'Z'; ++letter){
            alphabet.add(letter);
        }
        return alphabet;
    }
}
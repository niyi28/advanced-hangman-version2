package com.company.Hangman;

import java.util.ArrayList;

public class WordRandomizer{

    private GameWordsBasedOnLevel gameWordsBasedOnLevel = new GameWordsBasedOnLevel();
    private ArrayList <String> listOfWords;
    private int numberOfStoredWords;

    public WordRandomizer (){
        ArrayList <String> listOfWords = gameWordsBasedOnLevel.getWordsForChosenLevel();
        int numberOfStoredWords = listOfWords.size();
        this.listOfWords = listOfWords;
        this.numberOfStoredWords = numberOfStoredWords;
    }

    public int getRandomNumber(){
        int min = 0;
        int max = numberOfStoredWords;
        int randomNumber = (int)(Math.random()*((max-min)+1))+min;
        return randomNumber;
    }

    public String getRandomWord (){
        int randomNumber = getRandomNumber();
        //listOfWords.get(getRandomNumber(randomNumber))
        String randomWord = listOfWords.get(randomNumber);
        return randomWord;
    }

    public String convertoCharacter (String word, String character){
        String guessedWord = "";
        int lenOfWord = word.length();
        System.out.println("The chosen word has " + lenOfWord + " letters.");
        String gap = character;
        int i = 0;
        while(i < lenOfWord){
            guessedWord += gap;
            i++;
        }

        System.out.println(guessedWord);
        return guessedWord;
    }
}



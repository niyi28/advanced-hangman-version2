package com.company.Hangman;

import java.util.ArrayList;

public class Hangman {
    ScannerInitiator scannerInitiator = new ScannerInitiator();
    final private String username;

    public Hangman(String username){
        this.username = username;
    }

    private void playGame (){
        int numberOfPlaying = TimesYouWannaPlay.numOfPlayingTimes();
        System.out.println("\nLet's play!");
        WordRandomizer wordRandomizer = new WordRandomizer();
        int playerScore = 0;

        for(int playingCounter = 0; playingCounter < numberOfPlaying; playingCounter++){
            ArrayList<Character> remainingAlphabet = new ArrayList<Character>();

            for(char letter = 'A'; letter <= 'Z'; ++letter){
                remainingAlphabet.add(letter);
            }

            String randomWord = wordRandomizer.getRandomWord();
            String guessedWord = StringConverter.convertoCharacter(randomWord, "*");
            int lenOfRandomWord = randomWord.length();
            int numberOfFailedTries = 8;
            InputValidator inputValidator = new InputValidator();

            while(numberOfFailedTries > 0 ){
                String guessedLetter = inputValidator.getValidGuess();
                String guessedLetterUpperCase = guessedLetter.toUpperCase();
                Alphabets.printRemainingAlphabets(guessedLetterUpperCase.charAt(0), remainingAlphabet);
                int ifGuessTrue = 0;
                ArrayList <Integer> correctIndexes = new ArrayList <>();

                for (int letterNum = 0; letterNum < lenOfRandomWord; letterNum++ ){
                    if (guessedLetterUpperCase.charAt(0) == randomWord.charAt(letterNum)){
                        ifGuessTrue++;
                        correctIndexes.add(letterNum);
                    }
                }

                if (ifGuessTrue > 0){
                    playerScore = playerScore + 2;
                    for (int correctIndex : correctIndexes){
                        guessedWord = guessedWord.substring(0, correctIndex) + guessedLetterUpperCase +  guessedWord.substring(correctIndex + 1);
                    }
                } else{
                    HangmanDoom hangmanDoom = new HangmanDoom();
                    hangmanDoom.printhangmanDrawingWhenPlayerFails(numberOfFailedTries);
                    numberOfFailedTries--;
                    playerScore --;

                    printCorrectWordAfterEightTries(randomWord, numberOfFailedTries);
                }

                System.out.println("Guessed: " + guessedWord);

                if (randomWord.equals(guessedWord)){
                    break;
                }

                int playedtimes = playingCounter + 1;
                System.out.println("Hey " + username + ", you scored in your " + TimesYouWannaPlay.printTimesPlayed(playedtimes) + " playing time (s): " +  playerScore);
            }
        }
    }


    private void gameIntro(){
        HangmanIntro hangmanIntro = new HangmanIntro();
    }


    private void quitTheGame(){
        System.out.println(username + ", you quit!!");
    }

    private void printCredits(){
        System.out.println("Ashraf, Hanen, Niyi, Shiva and little Sophie");
        System.out.println("Word Source: EF website, https://www.ef.com/wwen/english-resources/english-vocabulary/top-3000-words/");
    }

    private void printTheInstructions(){
        HangmanIntro hangmanIntro = new HangmanIntro();
        hangmanIntro.printGameInstructions(username);
    }

    public void gameOverview(){
        gameIntro();
        gameChoiceImplementer();

    }

    private void printCorrectWordAfterEightTries(String word, int numberOfFailedTries){
        if (numberOfFailedTries == 0){

            System.out.println(username + ", the correct word is: " + word + ". You killed the man for nothing, learn!!");

        }

    }

    private void gameChoiceImplementer(){
        printTheInstructions();
        String chosenInstruction = getchosenInstruction();
        if (chosenInstruction.equals("P")){
            playGame();
            System.out.println("We hope you enjoyed the game, " + username);
            gameChoiceImplementer();
        } else if (chosenInstruction.equals("I") ){
            printTheInstructions();
            gameChoiceImplementer();
        }else if (chosenInstruction.equals("C")){
            printCredits();
            gameChoiceImplementer();
        }else if (chosenInstruction.equals("Q")){
            quitTheGame();
        }
    }


    private String getchosenInstruction(){
        System.out.print("\nChoose from the instructions: ");
        String chosenInstruction = scannerInitiator.getScannerString();
        return chosenInstruction.toUpperCase();
    }
}
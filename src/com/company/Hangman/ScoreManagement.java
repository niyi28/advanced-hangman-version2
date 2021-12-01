package com.company.Hangman;

import com.company.Login.ManagingDataBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScoreManagement {

    private int currentAvg = -1;
    private int currentScore;
    private final int numberOfUsers = ManagingDataBase.getDatabaseSize();
    private int bestScore = 0;


    public ScoreManagement(String username) throws IOException {
        setBestScore(username);
    }

    public void setBestScore(String username) throws IOException {
        this.bestScore = Integer.parseInt(ManagingDataBase.deriveUserScoreSheet(username).get(1));;
    }

    public int selectBestScore(String username, int currentScore) throws IOException {
        return Math.max(currentScore, bestScore);
    }

    public int getAverageScore(String username) throws IOException {
        bestScore = selectBestScore(username, currentScore);
        currentAvg =  ((currentAvg*(numberOfUsers-1)/numberOfUsers) +
                        (bestScore/numberOfUsers));
        return currentAvg;
    }

    public void setCurrentScore(String username, int currentScore) throws IOException {
        this.currentScore = currentScore;
        bestScore = selectBestScore(username, currentScore);
        System.out.println("current score: " + currentScore);
        System.out.println("best score: " + bestScore);
    }

    public List<String> getScores(){
        List <String> scores = new ArrayList<>();
        scores.add(String.valueOf(currentScore));
        scores.add(String.valueOf(bestScore));
        return scores;
    }
}

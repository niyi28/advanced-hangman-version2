package com.company.Login;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginValidation {

    private final Map<String, String> usernamesData = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);
    private String username;
/*
username, password
niyi    shivanIsnOTcool
shiva
*/

    public LoginValidation() {
        usernamesData.put("niyi", "cool12NapTime");
        usernamesData.put("school", "co1d2NapTime");
        usernamesData.put("pankow.school", "co1d2NapTime");

    }

    public String getUsername() {
        return username;
    }

    public Map<String, String> getUsernamesData() {
        return usernamesData;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private void toSignUp() {
        System.out.println("Signing up!!!!!");
        String username = "";
        boolean incorrectUsername = true;
        while(incorrectUsername){
            try{
                username = LoginDetails.getUsername();
                incorrectUsername = false;
            }catch(BadLoginDetails e){
                System.out.println(e.getMessage());
            }
        }
        String password = LoginDetails.getPassword();
        usernamesData.put(username, password);
        setUsername(username);
    }

    private void toSignIn() {
        System.out.println("Signing in!!!!!");
        String username = "";
        boolean incorrectUsername = true;
        while(incorrectUsername){
            try{
                username = LoginDetails.getUsername();
                toCheckInDatabase(username);
                incorrectUsername = false;
            }catch(BadLoginDetails e){
                System.out.println(e.getMessage());
            }
        }
        String password = LoginDetails.getPassword();
        toCheckPassword(username, password);
        setUsername(username);
    }

    private void toCheckInDatabase(String username){
        if (!usernamesData.containsKey(username.toLowerCase())){
            System.out.println("We do not have this username stored. Taking you back!!!");
            flockingIntoSocialFolks();
        }
    }

    private void toCheckPassword(String username, String password){
        int numberOfTries = 3;
        for (int i = numberOfTries; i > 0; i--){
            if (!password.equals(usernamesData.get(username))){
                System.out.println("Password is wrong and you have " + (i-1) + " number of tries left");
                password = LoginDetails.getPassword();

                if (i == 1){
                    throw new BadLoginDetails("Password is wrong");
                }
            }
        }
    }



    public void flockingIntoSocialFolks() {
        System.out.print("Please select 1 to sign in and other numbers or letters to sign up: ");
        String optionInputted = scanner.nextLine();
        returnFlockingOption(optionInputted);
    }

    private void returnFlockingOption(String optionInputted){
        if (optionInputted.equals("1")){
            toSignIn();
        }else{
            toSignUp();
        }
    }

}

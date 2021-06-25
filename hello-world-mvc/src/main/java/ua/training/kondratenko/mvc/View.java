package ua.training.kondratenko.mvc;

public class View {

    public static final String SYMBOLS = ", ";
    public static final String ERROR = "Wrong input! Try again!";

    public void showSentence(String firstWord, String secondWord){
        System.out.println(firstWord + SYMBOLS + secondWord);
    }

    public void showError(){
        System.out.println(ERROR);
    }
}
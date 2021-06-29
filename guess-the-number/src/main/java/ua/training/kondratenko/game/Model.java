package ua.training.kondratenko.game;

public class Model {
    private int randomNumber;
    private final int[] inputHistory = new int[100];
    private int inputCounter = 0;

    public int getRandomNumber() {
        return randomNumber;
    }

    public int[] getInputHistory() {
        return inputHistory;
    }

    public int getInputCounter() {
        return inputCounter;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public void incrementCounter(){
        inputCounter++;
    }
}
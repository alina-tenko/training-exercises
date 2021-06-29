package ua.training.kondratenko.game;

public class View {
    public static final String WELCOME = "Welcome! I picked a random number from 0 to 100. Please, try to guess it!";
    public static final String INPUT_NUMBER = "Please, enter number from 0 to 100";
    public static final String WRONG_INPUT = "Sorry! Wrong input. Try again";
    public static final String LOWER_INPUT = "Almost! The number is lower! Try again";
    public static final String HIGHER_INPUT = "Almost! The number is higher! Try again";
    public static final String CORRECT = "Congratulations! You've guessed the number!";

    private static final String TRIES = "Number of your tries: ";
    private static final String GUESS_NUMBER = "Attempt number ";
    private static final String USER_INPUT = ": you've entered ";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printHistory(int inputCounter, int[] inputHistory){

        printMessage(TRIES + (inputCounter + 1));

        int offset = 1;

        for (int i = 0; i <= inputCounter; i++ ){
            System.out.print(GUESS_NUMBER + offset);
            printMessage(USER_INPUT + inputHistory[i]);
            offset++;
        }
    }
}

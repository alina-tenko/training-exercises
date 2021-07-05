package ua.training.kondratenko.notebook;

/**
 * Class that represents view from MVC pattern.
 * This class is used for representing current model state.
 */
public class View {

    public static final String ENTER_A_NAME = "Enter a name: ";
    public static final String WRONG_INPUT = "Wrong input! Try again!";
    public static final String NAME_ACCEPTED = "Name accepted: ";

    /**
     * Method that prints a message into a console.
     * @param message message to print into console
     */
    public void printMessage(String message){
        System.out.println(message);
    }

}
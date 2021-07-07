package ua.training.kondratenko.notebook.controller;

import ua.training.kondratenko.notebook.model.Model;
import ua.training.kondratenko.notebook.view.KeyHolder;
import ua.training.kondratenko.notebook.view.View;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that represents controller from MVC pattern.
 * Controls and validates user input and decides how data is displayed.
 */
public class Controller {

    public static final Pattern NAME_PATTERN = Pattern.compile("[A-Z][a-z]+");

    private final View view;
    private final Model model;

    /**
     * Class constructor.
     */
    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    /**
     * Method that is responsible for getting an information from user input
     * and setting it to model.
     * @param locale locale. Locale could be ua or eng (default)
     */
    public void notebookFilling(String locale) {

        view.setLocale(locale);

        view.printLocalizedMessageFor(KeyHolder.KEY_ENTER_A_NAME);

        Scanner scanner = new Scanner(System.in);

        model.setName(getCorrectValue(scanner, NAME_PATTERN));

//        view.printMessage(View.NAME_ACCEPTED + model.getName());

        scanner.close();
    }

    /**
     * Method that checks if the given input is correct by pattern
     *
     * @param pattern Pattern
     * @param scanner Scanner
     * @return String - validated user input
     */
    public String getCorrectValue(Scanner scanner, Pattern pattern) {

        String correctValue = null;

        while (scanner.hasNextLine()) {

            String inputText = scanner.nextLine();

            Matcher inputTextMatcher = pattern.matcher(inputText);

            if (inputTextMatcher.matches()) {

                correctValue = inputText;
                break;
            } else {

//                view.printMessage(View.WRONG_INPUT);
            }
        }
        return correctValue;
    }
}

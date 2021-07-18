package ua.training.kondratenko.notebook.controller;

import ua.training.kondratenko.notebook.exceptions.WrongInputException;
import ua.training.kondratenko.notebook.model.Model;
import ua.training.kondratenko.notebook.view.KeyHolder;
import ua.training.kondratenko.notebook.view.RegexHolder;
import ua.training.kondratenko.notebook.view.View;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that represents controller from MVC pattern.
 * Controls and validates user input and decides how data is displayed.
 */
public class Controller {

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
     * Method that is responsible for getting information from user input
     * and setting it to model.
     * @param locale locale. Locale could be ua or eng (default)
     */
    public void notebookFilling(String locale) {

        view.setLocale(locale);

        final String welcomeMessage = view.getLocalizedMessageFor(KeyHolder.KEY_ENTER_A_NAME);

        view.printMessage(welcomeMessage);

        try (Scanner scanner = new Scanner(System.in)) {

            Pattern nameRegex = RegexHolder.LAT_REGEX_NAME;

            if (view.getLocale().equals("ua")) {
                nameRegex = RegexHolder.UKR_REGEX_NAME;
            }

            model.setName(getCorrectValue(scanner, nameRegex));

            final String nameAccepted = view.getLocalizedMessageFor(KeyHolder.KEY_NAME_ACCEPTED);

            view.printMessage(nameAccepted);

            final String nicknameMessage = view.getLocalizedMessageFor(KeyHolder.KEY_ENTER_A_NICKNAME);

            view.printMessage(nicknameMessage);

            final Pattern nicknameRegex = RegexHolder.NICKNAME_REGEX;

            model.setNickName(getCorrectValue(scanner, nicknameRegex));

            final String nicknameAccepted = view.getLocalizedMessageFor(KeyHolder.KEY_NICKNAME_ACCEPTED);

            view.printMessage(nicknameAccepted);
        }
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
                try {
                    throw new WrongInputException(view.getLocalizedMessageFor(KeyHolder.KEY_WRONG_INPUT));
                } catch (WrongInputException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
        return correctValue;
    }
}

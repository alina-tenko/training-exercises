package ua.training.kondratenko.notebook;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    public static final Pattern NAME_PATTERN = Pattern.compile("[A-Z][a-z]+");

    private final View view;
    private final Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void notebookFilling() {

        view.printMessage(View.ENTER_A_NAME);

        Scanner scanner = new Scanner(System.in);

        model.setName(getCorrectValue(scanner, NAME_PATTERN));

        view.printMessage(View.NAME_ACCEPTED + model.getName());

        scanner.close();
    }

    public String getCorrectValue(Scanner scanner, Pattern pattern) {

        String correctValue = null;

        while (scanner.hasNextLine()) {

            String inputText = scanner.nextLine();

            Matcher inputTextMatcher = pattern.matcher(inputText);

            if (inputTextMatcher.matches()) {

                correctValue = inputText;
                break;
            } else {

                view.printMessage(View.WRONG_INPUT);
            }
        }
        return correctValue;
    }
}

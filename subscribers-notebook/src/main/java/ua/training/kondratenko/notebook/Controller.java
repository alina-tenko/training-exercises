package ua.training.kondratenko.notebook;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    private final View view;
    private final Model model;

    public Controller(View view, Model model){
        this.view = view;
        this.model = model;
    }

    public void notebookFilling() {

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

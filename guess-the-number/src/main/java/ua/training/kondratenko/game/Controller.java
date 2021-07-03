package ua.training.kondratenko.game;

import java.util.Scanner;

public class Controller {

    private final View view;
    private final Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void startGame() {
        view.printMessage(View.WELCOME);

        Scanner scanner = new Scanner(System.in);

        int randomNumber = generateRandomNumber();

        model.setRandomNumber(randomNumber);

        while (true) {
            int userInput = inputIntValueWithScanner(scanner);

            if (userInput == model.getRandomNumber()) {
                view.printMessage(View.CORRECT);
                updateInputHistory(userInput);
                break;
            }
            if (userInput < model.getRandomNumber()) {
                view.printMessage(View.HIGHER_INPUT);
                updateInputHistory(userInput);
                model.incrementCounter();
            }
            if (userInput > model.getRandomNumber()) {
                view.printMessage(View.LOWER_INPUT);
                updateInputHistory(userInput);
                model.incrementCounter();
            }
        }

        view.printHistory(model.getInputCounter(), model.getInputHistory());

        scanner.close();
    }

    public int generateRandomNumber() {
        final int range = 100;
        return (int) (Math.random() * range) + 1;
    }

    private void updateInputHistory(int userInput) {
        int[] inputHistory = model.getInputHistory();
        inputHistory[model.getInputCounter()] = userInput;
    }

    public int inputIntValueWithScanner(Scanner scanner) {

        view.printMessage(View.INPUT_NUMBER);

        while (!scanner.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT + "\n" + View.INPUT_NUMBER);
            scanner.next();
        }

        return scanner.nextInt();
    }


}

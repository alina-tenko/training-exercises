package ua.training.kondratenko.mvc;

import java.util.Scanner;

public class Controller {

    private final View view;
    private final Model model;

    public Controller(View view, Model model){
        this.view = view;
        this.model = model;
    }

    public void manage(){

        final Scanner scanner = new Scanner(System.in);

        boolean isNotFirstMatch = true;
        boolean isNotSecondMatch = true;

        while (isNotFirstMatch){

            System.out.println("Please, type the first word: ");

            String first = scanner.nextLine();

            final String FIRST_MATCH = "Hello";
            if (FIRST_MATCH.equals(first)){
                model.setFirstWord(first);
                isNotFirstMatch = false;
            } else {
                view.showError();
            }
        }

        while (isNotSecondMatch) {

            System.out.println("Please, type the second word: ");

            String second = scanner.nextLine();

            final String SECOND_MATCH = "world";
            if (SECOND_MATCH.equals(second)) {
                model.setSecondWord(second);
                isNotSecondMatch = false;
            } else {
                view.showError();
            }
        }

        scanner.close();

        view.showSentence(model.getFirstWord(), model.getSecondWord());
    }
}
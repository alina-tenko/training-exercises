package ua.training.kondratenko.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameLauncherTest {

    private Controller controller;
    private Model model;
    private View view;

    @BeforeEach
    void setUp() {
        model = new Model();
        view = new View();
        controller = new Controller(view, model);
    }

    @Test
    void testGenerateRandomNumber() {

        for (int i = 0; i <= 10000; i++) {
            int randomNumber = controller.generateRandomNumber();

            if (randomNumber > 100 && randomNumber < 1){
                Assertions.fail();
            }
        }

    }
}
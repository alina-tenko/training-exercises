package ua.training.kondratenko.game;

public class GameLauncher {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);

        controller.startGame();
    }
}

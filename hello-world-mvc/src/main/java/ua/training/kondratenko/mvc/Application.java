package ua.training.kondratenko.mvc;

public class Application {

    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);

        controller.manage();
    }
}

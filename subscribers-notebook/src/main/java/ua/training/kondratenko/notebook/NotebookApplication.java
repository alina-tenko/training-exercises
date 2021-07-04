package ua.training.kondratenko.notebook;

public class NotebookApplication {

    public static void main(String[] args) {

        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);

        controller.notebookFilling();
    }
}
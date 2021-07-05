package ua.training.kondratenko.notebook;

/**
 * Entry point.
 * @author alina
 */
public class NotebookApplication {

    public static void main(String[] args) {

        final Controller controller = new Controller(new View(), new Model());

        controller.notebookFilling();
    }
}
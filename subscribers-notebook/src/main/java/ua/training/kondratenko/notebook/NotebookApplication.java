package ua.training.kondratenko.notebook;

import ua.training.kondratenko.notebook.controller.Controller;
import ua.training.kondratenko.notebook.model.Model;
import ua.training.kondratenko.notebook.view.View;

/**
 * Entry point.
 *
 * @author alina
 */
public class NotebookApplication {

    public static void main(String[] args) {

        String locale = "default";

        if (args.length > 0) {
            final String arg = args[0];
            if ("ua".equals(arg)) {
                locale = "ua";
            }
        }

        final Controller controller = new Controller(new View(), new Model());

        controller.notebookFilling(locale);
    }
}
package ua.training.kondratenko.notebook.view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Class that represents view from MVC pattern.
 * This class is used for representing current model state.
 */
public class View {

    private String locale = "default";

    private final ResourceBundle DEFAULT_BUNDLE = ResourceBundle.getBundle("messages");
    private final ResourceBundle UA_BUNDLE = ResourceBundle.getBundle(
            "messages", new Locale("ua", "UA"));

    /**
     * Method that prints a message into a console.
     * @param message message to print into console
     */
    private void printMessage(String message){
        System.out.println(message);
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void printLocalizedMessageFor(String messageKey) {
        final ResourceBundle selectedBundle = locale.equals("ua") ? UA_BUNDLE : DEFAULT_BUNDLE;

        final String localizedMessage = selectedBundle.getString(messageKey);

        printMessage(localizedMessage);
    }
}
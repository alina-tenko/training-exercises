package ua.training.kondratenko.notebook.view;

import java.util.ResourceBundle;

/**
 * Class that represents view from MVC pattern.
 * This class is used for representing current model state.
 */
public class View {

    private String locale = "default";

    /**
     * Method that prints a message into a console.
     *
     * @param message message to print into console
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getLocale() {
        return locale;
    }

    public String getLocalizedMessageFor(String messageKey) {

        final ResourceBundle selectedBundle = locale.equals("ua") ?
                LocalisationBundles.UA_BUNDLE.getBundle() :
                LocalisationBundles.DEFAULT_BUNDLE.getBundle();

        return selectedBundle.getString(messageKey);
    }
}
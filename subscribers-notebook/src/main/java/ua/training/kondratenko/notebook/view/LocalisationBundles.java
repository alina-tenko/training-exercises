package ua.training.kondratenko.notebook.view;

import java.util.Locale;
import java.util.ResourceBundle;

public enum LocalisationBundles {

    DEFAULT_BUNDLE(ResourceBundle.getBundle("messages")),
    UA_BUNDLE(ResourceBundle.getBundle("messages", new Locale("ua")));

    private final ResourceBundle bundle;

    LocalisationBundles(ResourceBundle resourceBundle) {
        this.bundle = resourceBundle;
    }

    public ResourceBundle getBundle() {
        return bundle;
    }
}
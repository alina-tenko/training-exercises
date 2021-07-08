package ua.training.kondratenko.notebook.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalisationBundles {

    public static final ResourceBundle DEFAULT_BUNDLE = ResourceBundle.getBundle("messages");

    public static final ResourceBundle UA_BUNDLE = ResourceBundle.getBundle(
            "messages",
            new Locale("ua", "UA"));
    }
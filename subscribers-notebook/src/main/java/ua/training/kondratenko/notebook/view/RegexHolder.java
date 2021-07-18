package ua.training.kondratenko.notebook.view;

import java.util.regex.Pattern;

public interface RegexHolder {

    Pattern LAT_REGEX_NAME = Pattern.compile("^[A-Z][a-z]{1,20}$");
    Pattern UKR_REGEX_NAME = Pattern.compile("^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$");
    Pattern NICKNAME_REGEX = Pattern.compile("^[A-Za-z0-9_-]{4,20}$");
}

package ua.training.kondratenko.notebook.view;

public interface RegexHolder {

    String UKR_REGEX_NAME = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    String LAT_REGEX_NAME = "^[A-Z][a-z]{1,20}$";
    String LOGIN_REGEX = "^[A-Za-z0-9_-]{8,20}$";
}

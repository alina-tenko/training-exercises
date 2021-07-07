package ua.training.kondratenko.notebook.model;

/**
 * Class that represents model from MVC pattern.
 * Data holder for name and nickname values.
 */
public class Model {

    private String name;
    private String nickName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}

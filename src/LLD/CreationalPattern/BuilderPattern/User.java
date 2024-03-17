package LLD.CreationalPattern.BuilderPattern;

public class User {
    private String name;
    private int id;

    public User(String username, int id) {
        this.name = username;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}


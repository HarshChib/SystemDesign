package LLD.CreationalPattern.BuilderPattern;

public class UserBuilder {
    private String name;
    private int id;

    public UserBuilder withUsername(String username) {
        this.name = username;
        return this;
    }

    public UserBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public User build() {
        return new User(name, id);
    }
}

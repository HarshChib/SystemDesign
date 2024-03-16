package LLD.CreationalPattern.PrototypePattern;

public class User implements Prototype{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Prototype clone() {
        return new User(this.name, this.age);
    }


}

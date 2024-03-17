package LLD.CreationalPattern.BuilderPattern;

public class BuilderMain {
    public static void main(String[] args) {
        User user1 = new UserBuilder()
                .withId(1)
                .withUsername("Harsh")
                .build();
        User user2 = new UserBuilder()
                .withId(1)
                .build();
        System.out.println(user1.toString());
        System.out.println(user2.toString());

    }
}

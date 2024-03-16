package lld.CreationalPattern.PrototypePattern;

/**
 * Prototype Pattern : Used to clone object
 */
public class PrototypeMain {
    public static void main(String[] args) {
        User user =  new User("Harsh", 24);
        User cloneUser = (User) user.clone();
        System.out.println(user);
        System.out.println(cloneUser);
    }
}

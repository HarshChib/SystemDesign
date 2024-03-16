package LLD.CreationalPattern.SingeltonPattern;

public class EagerInitialization {

    private static final EagerInitialization eagerInitialization = new EagerInitialization();

    private EagerInitialization() {}

    public static EagerInitialization getInstance() {
        return eagerInitialization;
    }

    public String getMessage() {
        return "This is eager initialization";
    }
}

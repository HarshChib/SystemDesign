package lld.CreationalPattern.SingeltonPattern;

public class LazyInitialization {

    private static LazyInitialization lazyInitialization;

    private LazyInitialization() {}

    public static LazyInitialization getInstance() {
        if(lazyInitialization == null) {
            lazyInitialization = new LazyInitialization();
        }
        return lazyInitialization;
    }

    public String getMessage() {
        return "This is lazy initialization";
    }
}


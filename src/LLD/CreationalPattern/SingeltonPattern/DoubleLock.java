package LLD.CreationalPattern.SingeltonPattern;

public class DoubleLock {
    private static DoubleLock doubleLock;

    private DoubleLock() {}

    public static DoubleLock getInstance() {
        if(doubleLock == null) {
            synchronized (DoubleLock.class) {
                if (doubleLock == null) {
                    doubleLock = new DoubleLock();
                }
            }
        }
        return doubleLock;
    }

    public String getMessage() {
        return "This is doubleLock initialization";
    }
}

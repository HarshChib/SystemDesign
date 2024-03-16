package lld.CreationalPattern.SingeltonPattern;

/**
 * We use singleton pattern when we need only one single object
 * We make constructor private and class getInstance method which
 * is the only instance of singleton class.
 * We have 4 initialization patterns for singleton classes :
 * 1. Eager -> Initializes at the time of class creation.
 * 2. Lazy -> Initializes at the time of getInstance method call.
 * 3. Synchronised -> Same as lazy but allow one thread at a time in the method.
 * 4. Double lock -> Same as lazy but checks keeps synchronised inside the condition.
 */
public class SingeltonMain {
    public static void main(String[] args) {
        EagerInitialization eagerInitialization1 = EagerInitialization.getInstance();
        EagerInitialization eagerInitialization2 = EagerInitialization.getInstance();
        System.out.println(eagerInitialization1.getMessage());
        System.out.println(eagerInitialization1);
        System.out.println(eagerInitialization2);

        LazyInitialization lazyInitialization1 = LazyInitialization.getInstance();
        LazyInitialization lazyInitialization2 = LazyInitialization.getInstance();
        System.out.println(lazyInitialization1.getMessage());
        System.out.println(lazyInitialization1);
        System.out.println(lazyInitialization2);

        SyncronizedInitialization syncronizedInitialization1 = SyncronizedInitialization.getInstance();
        SyncronizedInitialization syncronizedInitialization2 = SyncronizedInitialization.getInstance();
        System.out.println(syncronizedInitialization1.getMessage());
        System.out.println(syncronizedInitialization1);
        System.out.println(syncronizedInitialization2);

        DoubleLock doubleLock1 = DoubleLock.getInstance();
        DoubleLock doubleLock2 = DoubleLock.getInstance();
        System.out.println(doubleLock1.getMessage());
        System.out.println(doubleLock1);
        System.out.println(doubleLock2);
    }
}

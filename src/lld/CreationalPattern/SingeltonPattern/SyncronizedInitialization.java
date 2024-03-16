package lld.CreationalPattern.SingeltonPattern;

public class SyncronizedInitialization {
    private static SyncronizedInitialization syncronizedInitialization;

    private SyncronizedInitialization() {}

    public static synchronized SyncronizedInitialization getInstance() {
        if(syncronizedInitialization == null) {
            syncronizedInitialization = new SyncronizedInitialization();
        }
        return syncronizedInitialization;
    }

    public String getMessage() {
        return "This is syncronized initialization";
    }
}
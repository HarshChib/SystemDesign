package LLD.CreationalPattern.PrototypePattern;

public interface Prototype {
    /**
     * Using returnType as Prototype because interface can be implemented by
     * multiple classes.
     * @return
     */
    Prototype clone();
}

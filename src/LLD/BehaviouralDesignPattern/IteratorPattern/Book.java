package LLD.BehaviouralDesignPattern.IteratorPattern;

public class Book {
    private String name;
    private String authorName;

    public Book(String name, String authorName) {
        this.name = name;
        this.authorName = authorName;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    @Override
    public String toString() {
        return "BookName: " + name + " AuthorName: "+ authorName;
    }
}

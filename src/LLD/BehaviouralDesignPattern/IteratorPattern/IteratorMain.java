package LLD.BehaviouralDesignPattern.IteratorPattern;

import LLD.BehaviouralDesignPattern.IteratorPattern.Aggregator.Library;
import LLD.BehaviouralDesignPattern.IteratorPattern.Iterator.BookIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IteratorMain {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Book1","Harsh"),
                new Book("Book2","Dev"));

        Library library = new Library(books);
        BookIterator iterator = library.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}

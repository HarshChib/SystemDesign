package LLD.BehaviouralDesignPattern.IteratorPattern.Aggregator;

import LLD.BehaviouralDesignPattern.IteratorPattern.Book;
import LLD.BehaviouralDesignPattern.IteratorPattern.Iterator.BookIterator;

import java.util.List;

public class Library {
    private final List<Book> list;
    public Library(List<Book> list) {
        this.list = list;
    }

    public BookIterator iterator(){
        return new BookIterator(list);
    }
}

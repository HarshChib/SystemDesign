package LLD.BehaviouralDesignPattern.IteratorPattern.Iterator;

import LLD.BehaviouralDesignPattern.IteratorPattern.Book;
import LLD.BehaviouralDesignPattern.IteratorPattern.IterableInterface.IteratorInterface;

import java.util.List;

public class BookIterator implements IteratorInterface {

    private final List<Book> list;
    private int index;
    public BookIterator(List<Book> list) {
        this.index = 0;
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index<list.size();
    }

    @Override
    public Book next() {
        if(hasNext()){
            return list.get(index++);
        }
        return null;
    }
}

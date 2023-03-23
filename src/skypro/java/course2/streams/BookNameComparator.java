package skypro.java.course2.streams;

import java.util.Comparator;

// компаратор для книг, сортировака по названию
public class BookNameComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getName().compareTo(o2.getName());
    }

}

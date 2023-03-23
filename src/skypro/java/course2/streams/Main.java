package skypro.java.course2.streams;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // список из книг
        List<Book> books = Arrays.asList(
                new Book("Норвежский лес", "Харуки Мураками"),
                new Book("Дом, в котором", "Мариам Петросян"),
                new Book("Хроники заводной птицы", "Харуки Мураками"));

    }

    public static<T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

    }
}

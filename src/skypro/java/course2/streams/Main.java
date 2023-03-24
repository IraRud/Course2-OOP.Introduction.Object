package skypro.java.course2.streams;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        task1();

    }

    public static void task1() {

        // стрим из книг
        Stream<Book> books = Stream.of( new Book("Хроники заводной птицы", "Харуки Мураками"),
                new Book("Норвежский лес", "Харуки Мураками"),
                new Book("Дом, в котором", "Мариам Петросян"));

        // BiConsumer принимает два(!) параметра, выполняет действие, при этом ничего не возвращая
        BiConsumer<Book, Book> bookBiConsumer = (min, max) -> System.out.println("Min - " + min + ", max - " + max);
        // еще один компаратор для автора книги
        Comparator<Book> bookNameComparator = (b1, b2) -> b1.getAuthor().compareToIgnoreCase(b2.getAuthor());
        // еще один компаратор для сортировки сначала по автору, затем по названию
        Comparator<Book> bookNameAndAuthorComparator = Comparator.comparing(Book::getAuthor).thenComparing(Book::getName);

        // вызываем прописанный метод
        findMinMax(books, new BookNameComparator(), bookBiConsumer);

        // реализация пустого стрима
        Stream<Book> emptyBooks = Stream.of();
        findMinMax(emptyBooks, bookNameAndAuthorComparator, bookBiConsumer);

    }

    // мтеод для поиска минимума и максимума
    public static<T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        // из стрима получаем коллекцию
        List<T> list = stream.collect(Collectors.toList());
        // проверка на непустую коллекцию
        if (list.isEmpty()) {
            // если да - пустые значения для минимума и максимума
            minMaxConsumer.accept(null, null);
        } else {
            // если нет, сортируем заданным компаратором
            list.sort(order);
            // и записываем: в минимум - первое значение отсортированной коллекции
            // в максимум - послденне значение отсортированной коллекции, при помощи метода get(index)
            minMaxConsumer.accept(list.get(0), list.get(list.size()-1));
        }
    }

    public static void printSpecialSymbol() {
        System.out.println(" ヽ(*・ω・)ﾉ  ヽ(*・ω・)ﾉ  ヽ(*・ω・)ﾉ ");
    }

}

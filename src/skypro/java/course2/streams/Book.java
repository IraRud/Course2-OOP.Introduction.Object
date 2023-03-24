package skypro.java.course2.streams;

import java.util.Objects;

public class Book {

    final private String name;  // название книги
    final private String author;    // автор книги

    public Book(String name, String author) {
        this.name = validateStringValue(name);
        this.author = validateStringValue(author);
    }

    private String validateStringValue(String value) {
        return value == null || value.isBlank() || value.isEmpty() ? "неизвестно" : value;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author);
    }

    @Override
    public String toString() {
        return "Книга{" +
                "название='" + name + '\'' +
                ", автор='" + author + '\'' +
                '}';
    }

}

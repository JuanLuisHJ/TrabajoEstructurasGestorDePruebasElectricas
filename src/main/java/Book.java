import java.util.Arrays;

public class Book {
    private String title;
    private String isbn;
    private long year;
    private String[] authors;

    public Book() {
    }

    public Book(String title, String isbn, long year, String[] authors) {
        this.title = title;
        this.isbn = isbn;
        this.year = year;
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", year=" + year +
                ", authors=" + Arrays.toString(authors) +
                '}';
    }
}

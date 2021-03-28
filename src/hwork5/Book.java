package hwork5;

import java.util.Arrays;
import java.util.Objects;

public class Book {
    private String booksName = "Название книги";
    private int sumPages = 1;
    public Author[] authors;
    private int year = 1900;
    private int authorCount=1;

    public Book(String booksName, int sumPages, int year, int authorCount) {
        setBooksName(booksName);
        setSumPages(sumPages);
        setYear(year);
        setAuthorCount(authorCount);
        authors = new Author[authorCount];

    }

    public int getAuthorCount() {
        return authorCount;
    }

    public void setAuthorCount(int authorCount) {
        if(authorCount<1)throw new IllegalArgumentException("Слишком мало авторов");
        this.authorCount = authorCount;
    }

    public String getBooksName() {
        return booksName;
    }

    private void setBooksName(String booksName) {
        if (booksName == null || booksName.trim().length() < 1)
            throw new IllegalArgumentException("Название книги слишком короткое");
        this.booksName = booksName;
    }

    public int getSumPages() {
        return sumPages;
    }

    private void setSumPages(int sumPages) {
        if (sumPages < 2) {
            throw new IllegalArgumentException("Слишком мало страниц");
        }
        this.sumPages = sumPages;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        if (year > 2021 || year < 1700) throw new IllegalArgumentException("Некорректная дата");
        this.year = year;
    }

    public void addAuthor(Author author) {
        Objects.requireNonNull(author, "Автор не может быть null");
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) {
                authors[i] = author;
                return;
            }

        }
        System.out.println("ошибка");
    }

    @Override
    public String toString() {
        return "Book{" +
                "booksName='" + booksName + '\'' +
                ", summPages=" + sumPages +
                ", author='" + Arrays.toString(authors) + '\'' +
                ", year=" + year +
                '}';
    }
}

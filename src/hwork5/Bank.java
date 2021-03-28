package hwork5;

import java.util.Arrays;
import java.util.UUID;

public class Bank {
    private Book[] books;
    private UUID uuid;

    public Bank(int cauntBank) {
        books = new Book[cauntBank];
    }

    public void addBook(Book book) {
        for (int i = 0; i < books.length && i < 21; i++) {
            if (books[i] == null) {
                books[i]=book;
                return;
            }
        }
        System.out.println("Оштбка 2");
    }

    public UUID getUuid() {
        return uuid;
    }

    private void setUuid() {
        uuid = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Bank{" +
                "book=" + Arrays.toString(books) +
                ", uuid=" + uuid +
                '}';
    }
}

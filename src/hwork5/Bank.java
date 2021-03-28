package hwork5;

import java.util.Arrays;
import java.util.UUID;

public class Bank {
    private Book[] books;
    private UUID uuid;
    private int countBank=0;

    public Bank(int cauntBank) {
        books = new Book[cauntBank];
        setCountBank(cauntBank);
    }

    public int getCountBank() {
        return countBank;
    }

    public void setCountBank(int countBank) {
        if(countBank>20||countBank<0)throw new IllegalArgumentException("неверное значение");
        this.countBank = countBank;
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

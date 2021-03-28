package hwork5;

public class HW1 {
    public static void main(String[] args) {
        Author author1 = new Author("Антон", "Чехов");
        Book book1 = new Book("Палата №6", 134, 1923, 1);
        Book book2 = new Book("Пари", 229, 1945, 3);
        Author author2 = new Author("Александр", "Пушкин");
        Book book3 = new Book("Лукоморье", 543, 1900, 1);
        Author author3 = new Author("Михаил", "Лермонтов");
        Book book4 = new Book("Демон", 44, 1897, 4);
        Author author4 = new Author("Владимир", "Маяковский");
        Book book5 = new Book("Про это", 111, 1956, 1);


        Bank bank = new Bank(3);

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(bank);

    }
}

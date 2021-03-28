package hwork5;

public class Author {
    private String name = "Имя автора";
    private String surname = "Фамилия автора";

    public Author(String name, String surname) {
        setName(name);
        setSurname(surname);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < 2) throw new IllegalArgumentException("Слишком короткое имя");

        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    private void setSurname(String surname) {
        if (surname == null || name.trim().length() < 2) throw new IllegalArgumentException("Слишком короткая фамилия");

        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

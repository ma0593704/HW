package fitness;

import java.time.LocalDateTime;

public class PersonalData {
    protected String surname = "Фамилия";
    protected String name = "Имя";
    protected int yearsOld = 1999;
    protected LocalDateTime registrationDate = LocalDateTime.of(2021, 1, 1, 13, 13);
    protected LocalDateTime expirationDate = registrationDate.plusMonths(12);
    protected LocalDateTime dateOfVisite = LocalDateTime.now();

    public PersonalData(String surname, String name) {
        setSurname(surname);
        setName(name);
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.trim().length() < Settings.MIN_SURNAME)
            throw new IllegalArgumentException(" Слишком короткая фамилия ");
        this.surname = surname;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < Settings.MIN_NAME)
            throw new IllegalArgumentException(" Слишком короткое имя ");
        this.name = name;
    }

    public void setYearsOld(int yearsOld) {
        if (yearsOld > Settings.MIN_YEAR || yearsOld < Settings.MAX_YEAR)
            throw new IllegalArgumentException(" Посетитель несовершеннолетний, либо дата введена некорректно ");
        this.yearsOld = yearsOld;
    }

}

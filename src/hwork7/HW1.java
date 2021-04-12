package hwork7;

import java.util.Scanner;

/*
Класс Ученик
        создается со следующими характеристиками:
            имя (тип String)
            возраст (тип int)
            один изучаемый предмет (тип String)
            уровень знаний (тип int)
        и методом:
            учиться() - уровень знаний ученика повышается

        Класс Учитель
        создается со следующими харатеристиками:
            имя (тип String)
            возраст (тип int)
            один преподаваемый предмет (тип String)
        и методом:
            учить(обучаемый) - тип данных обучаемого определить самостоятельно

        Класс Директор
        создается со следующими харатеристиками:
            имя (тип String)
            возраст (тип int)
        и методами:
            объявить начало занятий()
            объявить окончание занятий занятий()

        Класс Школа
        создается со следующими харатеристиками:
            название - задается при создании объекта и не может быть изменено в последствии
            директор - школа не может функционировать без директора
            учителя[] - массив
            ученики[] - массив
        и методом:
            день в школе() -
                1. директор объявляет начало занятий
                2. учителя учат учеников (предмет учителя и ученика должны совпадать)
                3. директор объявляет окончание занятий

        Методы учить() и учиться() необходимо описать в разных интерфейсах(я это проигнорировал)
        Общие свойства необходимо вынести в родительские классы (какие определить самостоятельно)
        В классах можно добавлять методы и свойства при необходимости
 */
public class HW1 {
    public static void main(String[] args) {
        Apprentice apprentice1 = new Apprentice("Максим", 0, "Изо");
        Apprentice apprentice2 = new Apprentice("Алексей", 8, "Информатика");
        Apprentice apprentice3 = new Apprentice("Леонид", 4, "Математика");
        Apprentice apprentice4 = new Apprentice("Светлана", 10, "Французский");
        Apprentice apprentice5 = new Apprentice("Алиса", 1, "Математика");

        Teacher teacher1 = new Teacher("Галина", 34, "Математика");
        Teacher teacher2 = new Teacher("Светлана", 40, "Информатика");
        Teacher teacher3 = new Teacher("Валентина", 29, "Изо");
        Teacher teacher4 = new Teacher("Ирина", 33, "Французский");

        Director director = new Director("Иван", 45);
        School school = new School(4, 5);
        school.addTeacher(teacher1);
        school.addTeacher(teacher2);
        school.addTeacher(teacher3);
        school.addTeacher(teacher4);
        school.addApprentice(apprentice1);
        school.addApprentice(apprentice2);
        school.addApprentice(apprentice3);
        school.addApprentice(apprentice4);
        school.addApprentice(apprentice5);
        school.director = director;
        System.out.println(school);
        school.Day1(teacher3,apprentice1);
        school.Day1(teacher1,apprentice2);
        school.Day1(teacher2,apprentice3);
        school.Day1(teacher4,apprentice4);
        school.Day1(teacher4,apprentice5);
        System.out.println(school);







    }
}

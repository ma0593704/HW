package hwork11;

import java.time.LocalDate;
import java.util.*;

import java.util.function.Function;
import java.util.stream.Collectors;

public class PupilTask {
    public static void main(String[] args) {
        List<Pupil> pupils = new ArrayList<>(Arrays.asList(
                new Pupil(UUID.randomUUID(), "Женя", Pupil.Gender.MALE, LocalDate.now().minusYears(10)),
                new Pupil(UUID.randomUUID(), "Олег", Pupil.Gender.MALE, LocalDate.now().minusYears(7)),
                new Pupil(UUID.randomUUID(), "Алена", Pupil.Gender.FEMALE, LocalDate.now().minusYears(6)),
                new Pupil(UUID.randomUUID(), "Иван", Pupil.Gender.MALE, LocalDate.now().minusYears(12)),
                new Pupil(UUID.randomUUID(), "Алексей", Pupil.Gender.MALE, LocalDate.now().minusYears(9)),
                new Pupil(UUID.randomUUID(), "Петр", Pupil.Gender.MALE, LocalDate.now().minusYears(9)),
                new Pupil(UUID.randomUUID(), "Иван", Pupil.Gender.MALE, LocalDate.now().minusYears(17)),
                new Pupil(UUID.randomUUID(), "Петр", Pupil.Gender.MALE, LocalDate.now().minusYears(5)),
                new Pupil(UUID.randomUUID(), "Алена", Pupil.Gender.FEMALE, LocalDate.now().minusYears(8)),
                new Pupil(UUID.randomUUID(), "Алена", Pupil.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Pupil(UUID.randomUUID(), "Григорий", Pupil.Gender.MALE, LocalDate.now().minusYears(7)),
                new Pupil(UUID.randomUUID(), "Ирина", Pupil.Gender.FEMALE, LocalDate.now().minusYears(6))
        ));
        System.out.println(pupils);
        System.out.println();
        // Используя Stream API:

        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>
        Map<Pupil.Gender, ArrayList<Pupil>> byGender = pupils.stream().collect(Collectors.groupingBy(Pupil::getGender, Collectors.toCollection(ArrayList::new)));
        System.out.println(byGender);
        System.out.println();

        // 2. Найти средний возраст учеников
        double avage = pupils.stream().mapToInt(pupil -> LocalDate.now().getYear() - pupil.getBirth().getYear()).average().orElse(0);
        System.out.println(avage);
        System.out.println();

        // 3. Найти самого младшего ученика
        Pupil minA = pupils.stream().max(Comparator.comparing(Pupil::getBirth)).get();
        System.out.println(minA);
        System.out.println();

        // 4. Найти самого взрослого ученика
        Pupil maxA = pupils.stream().min(Comparator.comparing(Pupil::getBirth)).get();
        System.out.println(maxA);
        System.out.println();

        // 5. Собрать учеников в группы по году рождения
        Map<LocalDate, ArrayList<Pupil>> byBirth = pupils.stream().collect(Collectors.groupingBy(Pupil::getBirth, Collectors.toCollection(ArrayList::new)));
        System.out.println(byBirth);
        System.out.println();

        // 6. Оставить учеников с неповторяющимися именами,
        // имена и дату рождения оставшихся вывести в консоль.
        // Например, [Иван, Александра, Ольга, Иван, Ольга] -> [Иван, Александра, Ольга]
        Map<String, ArrayList<LocalDate>> byNam = pupils.stream().collect(Collectors.toMap(Function.identity(),Collectors.groupingBy(Pupil::getBirth),(i,i1)->i.toString()));
        System.out.println(byNam);
        System.out.println();
        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        pupils.sort(Comparator.comparing(Pupil::getGender).thenComparing(Pupil::getBirth).thenComparing(Pupil::getName).reversed());

        // 8. Вывести в консоль всех учеников в возрасте от N до M лет
        LocalDate n = LocalDate.now().minusYears(8);
        LocalDate m = LocalDate.now().minusYears(12);
        List<Pupil> we = pupils.stream().filter(pupil -> pupil.getBirth().isAfter(m) && pupil.getBirth().isBefore(n)).collect(Collectors.toList());
        System.out.println(we);
        System.out.println();

        // 9. Собрать в список всех учеников с именем=someName
        String namr = "Петр";
        List<Pupil> fff = pupils.stream().filter(pupil -> pupil.getName().equals(namr)).collect(Collectors.toList());

        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
        Map<Pupil.Gender, Integer> ffd = pupils.stream().collect(Collectors.groupingBy(Pupil::getGender, Collectors.summingInt(pupl -> LocalDate.now().getYear() - pupl.getBirth().getYear())));

    }
}
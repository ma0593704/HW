package hwork7;

public class Teacher implements ToStudy {
    private String name = "Имя учителя";
    private int age = 23;
    private String lesson = "Название предмета";


    public Teacher(String name, int age, String lesson) {
        setName(name);
        setAge(age);
        setLesson(lesson);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getLesson() {
        return lesson;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 2)
            throw new IllegalArgumentException("Слишком короткое имя Учтеля");
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 23 || age > 60) throw new IllegalArgumentException("Ученику меньше 23 лет или больше 60");
        this.age = age;
    }

    public void setLesson(String lesson) {
        if (lesson == null || lesson.trim().length() < 3)
            throw new IllegalArgumentException("Слишком короткое название предмета");
        this.lesson = lesson;
    }
    @Override
    public void toStudyT(Apprentice apprentice) {
        apprentice.lvlL += Settings.LVL_LESSON;
    }

    @Override
    public void toStudy(){}//как написать по другому эту строчку

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", lesson='" + lesson + '\'' +
                '}';
    }
}

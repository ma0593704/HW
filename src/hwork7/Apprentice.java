package hwork7;

public class Apprentice implements ToStudy {
    private String name = "Имя ученика";
    private int age = 8;
    private String lessonA = "Название предмета";
    public int lvlL = 0;


    public Apprentice(String name, int lvlL, String lesson) {
        setName(name);
        setLvlL(lvlL);
        setLesson(lesson);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getLesson() {
        return lessonA;
    }

    public int getLvlL() {
        return lvlL;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 2)
            throw new IllegalArgumentException("Слишком короткое имя Ученика");
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 8 || age > 10) throw new IllegalArgumentException("Ученику меньше 8 лет");
        this.age = age;
    }

    public void setLesson(String lesson) {
        if (lesson == null || lesson.trim().length() < 3)
            throw new IllegalArgumentException("Слишком короткое название предмета");
        this.lessonA = lesson;
    }

    public void setLvlL(int lvlL) {
        if (lvlL < 0) throw new IllegalArgumentException("Некорректный уровень ученика Ученика");
        this.lvlL = lvlL;
    }

    @Override
    public void toStudy() {
        if (lvlL < 0) return;
        lvlL += Settings.LVL_LESSON;
    }

    @Override
    public void toStudyT(Apprentice apprentice) {
    }//как написать по другому эту строчку

    @Override
    public String toString() {
        return "Apprentice{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", lesson='" + lessonA + '\'' +
                ", lvlL=" + lvlL +
                '}';
    }
}

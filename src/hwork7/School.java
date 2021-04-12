package hwork7;

import java.util.Arrays;

public class School implements ToStudy{
    private static boolean START = false;
    private final String name = "Школа №12";
    public Director director;
    public Teacher[] teachers;
    public Apprentice[] apprentices;
    private int countTeacher;
    private int countApprentice;

    public School(int countTeacher, int countApprentice) {
        if (countTeacher <= 0) throw new IllegalArgumentException("Значение не может быть меньше 0");
        if (countApprentice <= 0) throw new IllegalArgumentException("Значение не может быть меньше 0");
        this.countTeacher = countTeacher;
        this.countApprentice = countApprentice;
        teachers = new Teacher[countTeacher];
        apprentices = new Apprentice[countApprentice];

    }

    public void addTeacher(Teacher teacher) {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
                teachers[i] = teacher;
                return;
            }
        }
    }

    public void addApprentice(Apprentice apprentice) {
        for (int i = 0; i < apprentices.length; i++) {
            if (apprentices[i] == null) {
                apprentices[i] = apprentice;
                return;
            }
        }
    }

    public void Day1(Teacher teacher,Apprentice apprentice) {
        director.startDay("start");
        if(teacher.getLesson()==apprentice.getLesson()){
            apprentice.lvlL += Settings.LVL_LESSON;
        }
        director.endDay("end");
    }
    @Override
    public void toStudyT(Apprentice apprentice) {
        apprentice.lvlL += Settings.LVL_LESSON;
    }

    @Override
    public void toStudy(){}//как написать по другому эту строчку

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", director=" + director +
                ", teachers=" + Arrays.toString(teachers) +
                ", apprentices=" + Arrays.toString(apprentices) +
                '}';
    }
}

package hwork7;

public class Director {
    private String name;
    private int age = 23;
    private String startDay;
    private String endDay;

    public Director(String name, int age) {
        setName(name);
        setAge(age);
    }

    public void startDay(String startDay){
        if(startDay!="start")throw new IllegalArgumentException("Директор не объявил начало занятий");
    }

    public void endDay(String endDay) {
        if(endDay!="end")throw new IllegalArgumentException("Директор не объявил конец занятий");;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public void setName(String name) {
        if (name == null || name.trim().length() < 2)
            throw new IllegalArgumentException("Слишком короткое имя Директора");
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 23 || age > 60) throw new IllegalArgumentException("Директору меньше 23 лет или больше 60");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

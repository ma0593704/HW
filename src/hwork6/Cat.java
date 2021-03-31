package hwork6;

import java.util.Arrays;

public class Cat {
    private String name;
    private String color;
    private int speed = 0;
    private int ves = 0;
    public Mouse[] mouses;
    private int count;

    public Cat(String name, int speed, int ves, int count) {
        setName(name);
        setSpeed(speed);
        setVes(ves);
        setCount(count);
        mouses = new Mouse[count];
    }

    public void addMouse(Mouse mouse) {
        for (int i = 0; i < mouses.length; i++) {
            if (mouses[i] == null && speed >= mouse.getSpeedM()&&ves>=getVes()) {
                mouses[i] = mouse;
                return;
            }
            //if (this.ves<=ves)mouses[i] = null;
        }

    }
    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    public int getVes() {
        return ves;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 1)
            throw new IllegalArgumentException("Имя не может быть null и меньше 1 буквы");
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCount(int count) {
        if (count < 0) throw new IllegalArgumentException("Некорректное число");
        this.count = count;
    }

    public void setSpeed(int speed) {
        if (speed < 0) throw new IllegalArgumentException("Отрицательная скорость");
        this.speed = speed;
    }

    public void setVes(int ves) {
        if (ves < 0) throw new IllegalArgumentException("Отрицательный вес");
        this.ves = ves;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", speed=" + speed +
                ", ves=" + ves +
                ", mouses=" + Arrays.toString(mouses) +
                ", count=" + count +
                '}';
    }
}

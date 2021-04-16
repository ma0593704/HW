package hwork9;

import java.util.Comparator;
import java.util.TreeSet;

public class CarComparing {
    public static void main(String[] args) {

        Comparator<Car> comparator = new Car.priceComparator()
                .thenComparing(new Car.colorComparator())
                .thenComparing(new Car.brendComparator());

        // сортировать по значениям свойств: price, color, brand
        Car blackOpel = new Car("black", "opel", 2000);
        Car redOpel = new Car("red", "opel", 2500);
        Car yellowMazda = new Car("yellow", "mazda", 3000);
        Car greenMazda = new Car("green", "mazda", 3000);
        TreeSet<Car> carTreeSet = new TreeSet<>(comparator);
        carTreeSet.add(blackOpel);
        carTreeSet.add(redOpel);
        carTreeSet.add(yellowMazda);
        carTreeSet.add(greenMazda);
        //Collections.sort посмотреть
        for (Car a:carTreeSet) {
            System.out.println(a);
        }

    }
}
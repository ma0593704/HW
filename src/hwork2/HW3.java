package hwork2;

import java.sql.SQLOutput;
import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество тарелок");
        double late = in.nextInt();
        System.out.println("Введите количество моющего средства");
        double fairy = in.nextInt();
        do  {
            System.out.println("Моющего средства осталось = " + fairy);
            System.out.println("Грязных тарелок = " + late);
            late--;
            fairy -= 0.5;
        }
        while (late >= 0);
    }
}

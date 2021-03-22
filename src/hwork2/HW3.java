package hwork2;


import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество тарелок");
        int late = in.nextInt();
        System.out.println("Введите количество моющего средства");
        double fairy = in.nextDouble();
        while (late >= 0 && fairy>=0 )  {

            System.out.println("Моющего средства осталось = " + fairy);
            System.out.println("Грязных тарелок = " + late);
            late--;
            fairy -= 0.5;


        }

    }
}

package hwork2;

import java.util.Scanner;

public class HW4 {
    public static void main(String[] args) {
        double i = Math.random() * 10;
        int a = (int) i;
        System.out.println("Загаданное число = " + a);
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число от 1 до 9 или 0 для выхода");
        int number = in.nextInt();
        if (number == 0) return;
        else if (number > 10) System.out.println("Неккоректная цифра");
        else {
            if (number == a) System.out.println("Вы угадали!");
            else if (number < a) System.out.println("Загаданное число меньше");
            else System.out.println("Загаданное число больше");
        }

    }
}

package hwork2;

import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество правильных ответов");
        int count = in.nextInt();
        if (count < 0) System.out.println("Неккоректно введены данные");
        else if (count <= 39) System.out.println("Попробуйте в следующий раз");
        else if (count <= 59) System.out.println("Удовлетворительно");
        else if (count <= 89) System.out.println("Хорошо");
        else if (count <= 100) System.out.println("Отлично");
        else System.out.println("Больше 100? Серьезно?");


    }
}

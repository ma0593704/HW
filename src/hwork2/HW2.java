package hwork2;

import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double result;
        System.out.println("Введите первое число");
        int first_number = in.nextInt();
        System.out.println("Введите второе число");
        int second_number = in.nextInt();
        System.out.println("Введите 3,5,7 или 9");
        int third_number = in.nextInt();
        switch (third_number) {
            case 3:
                result = first_number + second_number + third_number;
                System.out.println(result);
                break;
            case 5:
                result = first_number - second_number - third_number;
                System.out.println(result);
                break;
            case 7:
                result = first_number * second_number * third_number;
                System.out.println(result);
                break;
            case 9:
                result = (first_number / second_number) / third_number;
                System.out.println(result);
                break;
            default:
                System.out.println("Необходимо ввести 3,5,7 или 9");
        }

    }
}

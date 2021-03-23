package hwork2;

public class HW5 {
    public static void main(String[] args) {
        double i = Math.random() * 1000;
        int a = (int) i;
        System.out.println("Случайное число " + a);
        if (a > 10 && a < 500) {
            if (a > 200) System.out.println("Случайное число " + a + " не содержится в интервале (25;200)");
            else if (a < 25) System.out.println("Случайное число " + a + " не содержится в интервале (25;200)");
            else System.out.println("Случайное число " + a + " содержится в интервале (25;200)");

        }

       /* a = 1;
        b = 100;
        c = 0;
        while (true){
            c = a + (b - a) /2;
            System.out.println(c);
            // это число равно с?
            // с число больше 50?
            if (ans == 1) {
                a = c + 1;
            } else {
                b = c - 1;
            }*/
        }
    }


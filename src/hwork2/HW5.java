package hwork2;

public class HW5 {
    public static void main(String[] args) {
        double i = Math.random() * 1000;
        int a = (int) i;
        System.out.println("Случайное число " + a);
        if (a < 10) return;
        else if (a > 500) return;
        else {
            if (a > 200) System.out.println("Случайное число " + a + " не содержится в интервале (25;200)");
            else if (a < 25) System.out.println("Случайное число " + a + " не содержится в интервале (25;200)");
            else System.out.println("Случайное число " + a + " содержится в интервале (25;200)");
        }
    }
}

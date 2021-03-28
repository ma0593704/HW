package hwork4;

import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner ms = new Scanner(System.in);
        String[] m = {"дом", "домик", "домой", "одомашненный", "домовой", "домовитый", "пруд", "земля"};
        String s;
        String s1;
        int count = 0;
        boolean a;

        // stt.toCharArray();

        for (int i = 0; i < m.length; i++) {
            s = String.join(", ", m);
a=s.contains("дом");
            System.out.println(a);
            //if (a) count++;
            System.out.println(s);
        }
        //System.out.println(count);
    }
}

package hwork4;

import java.util.Arrays;
import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        Scanner ms = new Scanner(System.in);
       ////Как использовать            int arrlen = Integer.parseInt(scanner.nextLine());   ??????
        String[] m = new String[6];
        boolean a, c;
        String b = "exit";
        h:
        for (int i = 0; i < m.length; i++) {
            String mss = ms.nextLine();
            m[i] = mss;
            for (int j = m.length - 1; j >= 0; j--) {
                c = m[i].equalsIgnoreCase(m[j]);
                if (i == j) continue;
                if (c == true) {
                    System.out.println("Такое слово уже есть");
                    String mss1 = ms.nextLine();
                    m[i] = mss1;
                }
            }
            a = mss.equalsIgnoreCase(b);
            if (a) break h;

        }
        System.out.println(Arrays.toString(m));


    }
}
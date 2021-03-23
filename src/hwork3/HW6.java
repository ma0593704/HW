package hwork3;

import java.util.Arrays;

public class HW6 {
    public static void main(String[] args) {
        int[] m = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int a;
        for (int i = 0, j = 9; i < m.length && i < j; i++, j--) {
            if (m[i] < m[j]) {
                a = m[i];
                m[i] = m[j];
                m[j] = a;
            }
        }
        System.out.println(Arrays.toString(m));
    }
}

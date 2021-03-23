package hwork3;

import java.util.Arrays;

public class HW7 {
    public static void main(String[] args) {
        int[] m = new int[11];
        for (int i = 0; i < m.length; i++) {
            m[i]+=Math.random();
        }
        System.out.println(Arrays.toString(m));
    }
}

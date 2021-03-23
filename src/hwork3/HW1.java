package hwork3;

import java.util.Arrays;

public class HW1 {
    public static void main(String[] args) {
        int[] m1 = {12, 4690, 35, -53, 888, 32, -5, -77};
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        System.out.println(Arrays.toString(m1));
        for (int i = 0; i < m1.length; i++) {
            if (m1[i] > min) min = m1[i];
            if (m1[i] < max) max = m1[i];
        }
        System.out.println(min);
        System.out.println(max);
        Arrays.sort(m1);
        System.out.println(Arrays.toString(m1));
        int a = Arrays.binarySearch(m1, max);
        int b = Arrays.binarySearch(m1, min);
        m1[a] = min;
        m1[b] = max;
        System.out.println(Arrays.toString(m1));
    }
}

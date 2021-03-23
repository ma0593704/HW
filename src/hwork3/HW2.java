package hwork3;

import java.util.Arrays;

public class HW2 {
    public static void main(String[] args) {
        double max = Double.MAX_VALUE;
        double min = Double.MIN_VALUE;
        double[] m1 = new double[20];
        for (int i = 0; i < m1.length; i++) {
            m1[i] += Math.random() * 497 + 3;
            if (m1[i] > min) min = m1[i];
            if (m1[i] < max) max = m1[i];
        }
        System.out.println(Arrays.toString(m1));
        Arrays.sort(m1);
        System.out.println(max);
        System.out.println(min);
        System.out.println(Arrays.toString(m1));
        int a = Arrays.binarySearch(m1, max);
        int b = Arrays.binarySearch(m1, min);
        m1[a] = min;
        m1[b] = max;
        System.out.println(Arrays.toString(m1));
    }
}

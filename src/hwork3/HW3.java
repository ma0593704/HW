package hwork3;

import java.util.Arrays;

public class HW3 {
    public static void main(String[] args) {
        int count1 = 0, count2 = 0, count3 = -1, count4 = -1;
        int[] m1 = {78, 32, 76, 100, 0, 6301, 331, 77, 24, 2, 90};
        Arrays.sort(m1);
        for (int i = 0; i < m1.length; i++) {
            if (m1[i] % 2 == 0) count1++;
            if (m1[i] % 2 != 0) count2++;
        }
        int[] h = new int[count1];
        int[] hh = new int[count2];
        System.out.println(Arrays.toString(m1));
        for (int i = 0; i < m1.length; i++) {
            if (m1[i] % 2 == 0) {
                count3++;
                for (int j = count3; j < h.length; j++) {
                    h[j] = m1[i];
                }
            }
        }
        for (int i = 0; i < m1.length; i++) {
            if (m1[i] % 2 != 0) {
                count4++;
                for (int j = count4; j < hh.length; j++) {
                    hh[j] = m1[i];

                }
            }
        }
        System.out.println(Arrays.toString(h));
        System.out.println(Arrays.toString(hh));
    }
}

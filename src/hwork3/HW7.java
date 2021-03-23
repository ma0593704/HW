package hwork3;

import java.util.Arrays;

public class HW7 {
    public static void main(String[] args) {
        int[] m1 = new int[11];
        int count = 0, count1 = 0, count2 = 0;
        int q=Integer.MAX_VALUE,w=Integer.MAX_VALUE,e=Integer.MAX_VALUE;
        for (int i = 0; i < m1.length; i++) {
            m1[i] += Math.random() * (-3) + 1.5;
            if (m1[i] > 0) {
                count++;
                q = m1[i];
            }
            if (m1[i] == 0) {
                count1++;
                w = m1[i];
            }
            if (m1[i] < 0) {
                count2++;
                e = m1[i];
            }
        }
        if (count > count1 && count > count2) System.out.println(count + " " + q);
        else if (count1 > count && count1 > count2) System.out.println(count1 + " " + w);
        else if (count2 > count && count2 > count1) System.out.println(count2 + " " + e);
        else if (count1 == count&&count==count1) System.out.println(count1 +  " это " + q + " и " + w);
        else if (count2 == count&&count==count2) System.out.println(count2 +  " это " + q + " и " + e);
        System.out.println(Arrays.toString(m1));
    }
}

package hwork3;

import java.util.Arrays;

public class HW5 {
    public static void main(String[] args) {
        int[] m = {-321, 894, -45, 782, -29, 12, -88};
        Arrays.sort(m);
        int count = 0, count1 = -1;
        System.out.println(Arrays.toString(m));
        for (int i = 0; i < m.length; i++) {
            if (m[i] < 0) count++;
        }
        int[] n = new int[count];
        for (int i = 0; i < m.length; i++) {
            if (m[i] < 0) {
                count1++;
                for (int j = count1; j < n.length; j++) {
                    n[j] = m[i];
                }
            }
        }
        System.out.println(Arrays.toString(n));
    }
}

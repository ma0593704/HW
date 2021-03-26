package hwork4;

import java.util.Arrays;
import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        boolean c=false;
        Scanner ms = new Scanner(System.in);
        String mss = ms.nextLine();
        mss = mss.replaceAll("\\s+","");
        String [] mss1=mss.split("");
        System.out.println(Arrays.toString(mss1));
        for (int i = 0,j=mss1.length-1; i <mss1.length&&j>=0 ; i++,j--) {
            c = mss1[i].equalsIgnoreCase(mss1[j]);
            if (c==false)break;
        }
        System.out.println(c);
    }
}

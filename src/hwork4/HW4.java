package hwork4;

import java.util.Arrays;
import java.util.Scanner;

public class HW4 {
    public static void main(String[] args) {
        Scanner ms = new Scanner(System.in);
        String mss = ms.nextLine();
        mss = mss.replaceAll("\\s+","");
        String [] mss1=mss.split("");
        System.out.println(Arrays.toString(mss1));

        // mss.charAt(0)
        // mss.substring(0,1).toUpperCase()
        for (int i = 0; i < mss1.length; i++) {
            if(i==0){
            }

        }
    }
}

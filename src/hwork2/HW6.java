package hwork2;

import java.util.Scanner;

public class HW6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = 100;
        gg:
        do {
            System.out.println("Это " + a);
            int n = in.nextInt();
            if (n == 1) {
                System.out.println("easy " + a);
                break gg;
            } else if (n == 0) {
                for (int i = a / 2; i > 0; i /= 2) {
                    System.out.println("Это " + i);
                    int n1 = in.nextInt();
                    if (n1 == 0){
                        System.out.println(">");
                    int n2 = in.nextInt();
                    if (n2==1){
                        for (int w=i;w>50 || w<100;w/=2){
                            System.out.println(w);
                        }
                    }
                    }
                else if (n1 == 1) System.out.println("easy " + i);
                    break gg;
                }
            }
        } while (true);
    }
}



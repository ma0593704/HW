package hwork1;

public class HW3 {
    public static void main (String[] args){
        short a=440;
        int b=a/100+((a-a/100*100)/10)+(a-a/100*100-(a-a/100*100)/10*10);
        System.out.println(b);

    }
}

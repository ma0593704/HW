package hwork10;


import java.util.ArrayList;
import java.util.HashMap;

public class HW1 {
    public void addTextO(String a) {
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";
        String[] text1 = text.split(" ");
        HashMap<String, Integer> d = new HashMap<>();
        for (String text2 : text1) {
            if (text2.equals(a)) d.put(a, d.getOrDefault(a, 0) + 1);
        }
        System.out.println(d + " четвертая задача");
    }
    public void addTop(String text) {
        String[] text1 = text.split(" ");
        //ArrayList<Integer> qq = new ArrayList<>();
        for (String e:text1) {
            int l=e.length();
            System.out.println(l);
        }
       int[] ee = new int[];


        HashMap<String, Integer> Top = new HashMap<>();
        for (String z : text1) {
            Top.put(z, Top.getOrDefault(z, 0) + 1);
        }
        System.out.println(Top);

    }

    /*public void addTop(String text) {
        String[] text1 = text.split(" ");
        ArrayList<String> qq = new ArrayList<>();

        HashMap<String, Integer> Top = new HashMap<>();
        for (String z : text1) {
            Top.put(z, Top.getOrDefault(z, 0) + 1);
        }
        System.out.println(Top);

    }

     */
}

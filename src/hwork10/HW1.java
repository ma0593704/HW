package hwork10;


import java.lang.reflect.Array;
import java.util.*;

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

    public void addCount(String text) {
        String[] text1 = text.split(" ");
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        for (String e : text1) {
            if (!map.containsKey(e.length())) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(e);
                map.put(e.length(), arrayList);
            } else {
                map.get(e.length()).add(e);
            }
        }
        System.out.println("пятая задача");
        System.out.println(map);

    }

    //Написать метод, который выводит в консоль топ 10 самых частых слов
    public void addTop(String text) {
        Comparator Comp = new Comparator1();
        String[] text1 = text.toUpperCase().split(" ");
        HashMap<String, Integer> Top = new HashMap<>();
        for (String z : text1) {
            Top.put(z, Top.getOrDefault(z, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list1 = new ArrayList<>(Top.entrySet());
        list1.sort(Comp);
        List<Map.Entry<String, Integer>> list2 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            if (i < 10) {
                list2.add(list1.get(i));
            }
        }
        System.out.println("шестая задача");
        System.out.println(list2);

    }

    class Comparator1 implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return Integer.compare(o2.getValue(), o1.getValue());
        }
    }

    //вывести частоту встречаемости букв английского алфавита в данном тексте. Вывести в процентах для каждой буквы
    public void addF(String text) {
        String[] text1 = text.toUpperCase().split(" ");
        List<char[]> list = new ArrayList<>();
        Map<Character, Double> e = new HashMap<>();
        for (String t : text1) {
            list.add(t.toCharArray());
        }
        for (char[] i : list) {
            for (char ii : i) {
                e.put(ii, e.getOrDefault(ii, 0.0) + 1);
            }
        }
        Double w = 0.0;
        for (Map.Entry q : e.entrySet()) {
            w = w + (Double) q.getValue();
        }
        for (Map.Entry q : e.entrySet()) {
            q.setValue((Double) q.getValue() * 100 / w);
        }
        System.out.println(" задача семь");
        System.out.println(e);

    }
}




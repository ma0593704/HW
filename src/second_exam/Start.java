package second_exam;


import java.lang.reflect.Field;
import java.util.*;


public class Start implements Command {
    private Menu theMenu;
    private HashMap<String, String> map1 = new HashMap();
    private List<String> list1 = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();

    public Start(Menu theMenu) {
        this.theMenu = theMenu;
    }


    @Override
    public void execute() {
        theMenu.Start();
        Scanner sc = new Scanner(System.in);
        Class<?> cls = Settings.class;
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            list1.add(field.getName());
            try {
                list2.add((String) field.get(Object.class));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            map1.put(list1.get(i), list2.get(i));
        }
        //игра
        System.out.println(Settings.START_GAME);
        System.out.println(Settings.OPTION_1);
        System.out.println(Settings.OPTION_2);
        System.out.println(Settings.EXIT_TO_MENU);

        int count1 = 1, count2 = 2, count3 = 3, count4 = 4;
        while (true) {
            String qwe = sc.nextLine();
            if (qwe.equals("1")) {
                String d = "START_OPTION_" + count1;
                String a = "OPTION_" + count3;
                String b = "OPTION_" + count4;
                System.out.println(map1.get(d));
                if (map1.get(d).contains("успехом") || map1.get(d).contains("неудачей")) {
                    break;
                }
                System.out.println(map1.get(a));
                System.out.println(map1.get(b));
                System.out.println(map1.get("EXIT_TO_MENU"));
                if (count1 == 5) {
                    count1 += 2;
                    count3 += 2;
                    count4 += 2;
                }
            }

            if (qwe.equals("2")) {
                if (count1 == 5) {
                    count3 += 2;
                    count4 += 2;
                }
                String d = "START_OPTION_" + count2;
                String a = "OPTION_" + count3;
                String b = "OPTION_" + count4;
                System.out.println(map1.get(d));
                if (map1.get(d).contains("успехом") || map1.get(d).contains("неудачей")) {
                    break;
                }
                System.out.println(map1.get(a));
                System.out.println(map1.get(b));
                System.out.println(map1.get("EXIT_TO_MENU"));
            }
            count2 += 2;
            count3 += 2;
            count1 += 2;
            count4 += 2;
            if (qwe.equals("5")) {
                boolean aa = true;
                Application2 a = new Application2();
                a.StartGame(aa,count1,count2,count3,count4);
                break;


            }
        }
    }
}

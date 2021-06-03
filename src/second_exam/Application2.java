package second_exam;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Application2 {

/*
Взаимодействие с пользователем должно быть реализовано через консоль.
Меню должно быть реализовано с помощью паттерна Команда, где каждый пункт меню - отдельная команда.

Меню:
1. Начать игру
2. Загрузить игру
3. Выйти

После начала игры должна быть возможность выйти в меню при этом в меню появляется новый пункт 'Сохранить игру'.

Когда пользователь выбирает пункт 'Сохранить игру' состояние игры необходимо сохранять в файл и
восстанавливать при выборе пункта 'Загрузить игру'.
 */

    //спросить как обновить поле или удалить данные
    //как получить цифру из загружаемого файла
    //как не делать две проверки цифр в меню
    boolean b=false;

    public void StartGame(boolean b,int z1,int z2,int z3,int z4) {


        Menu menu = new Menu();
        Command command1 = new Save(menu);
        Command command2 = new Start(menu);
        Command command3 = new Exit(menu);
        Command command4 = new Load(menu);

        Asd ss = new Asd(command2, command4, command1, command3);
        System.out.println(Settings.MENU);
        System.out.println(Settings.START);
        System.out.println(Settings.LOAD);
        System.out.println(Settings.EXIT);
        if(b) System.out.println(Settings.SAVE);
        while (true) {
            Scanner sc = new Scanner(System.in);
            String number = sc.nextLine();
            if (!(Settings.START.contains(number) || Settings.EXIT.contains(number) || Settings.LOAD.contains(number) || Settings.EXIT_TO_MENU.contains(number) || Settings.SAVE.contains(number))) {
                System.out.println("Введен некорректный номер меню, попробуйте еще раз!");
            }
            //начало игры
            if (Settings.START.contains(number)){
                ss.start();

                            }
            //выход из игры
            if (Settings.EXIT.contains(number)) {
                break;
            }
            //загрузка цифры
            if (Settings.LOAD.contains(number)) {
                SaveAndLoad save = new SaveAndLoad(new File("file.txt"));
                try {
                    System.out.println(save.readFromFile());
                } catch (IOException e) {
                    System.out.println("Ошибка загрузки");
                }
            }
            //сохранение цифры
            if (Settings.SAVE.contains(number)) {
                String t=""+z1+z2+z3+z4;
                SaveAndLoad save = new SaveAndLoad(new File("file.txt"));
                try {
                    System.out.println(save.writeToFile(t.getBytes()));
                } catch (IOException e) {
                    System.out.println("Ошибка сохранения");
                }
            }
        }
    }
}
//свич
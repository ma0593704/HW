package hwork12;

import java.io.File;

public class App {
    public static void main(String[] args) {
        //Написать декораторы, наследующиеся от FilterOutputStream и FilterInputStream,
        //шифрующие и дешифрующие исходящие и входящие байты XOR-шифрованием. ^

        //программа -> decorator(outputStream) -> outputStream
        //программа <- decorator(inputStream) <- inputStream

        String text = "Попробуем зашифровать эту строку";
        String text1 = "Это ключ";
        System.out.println(text);
        System.out.println(text1);
        HW2 txt = new HW2(new File("file.txt"));
        System.out.println(txt.writeToFile(text.getBytes()));

        String fromFile = new String(txt.readFromFile());
        System.out.println(fromFile);

    }
}

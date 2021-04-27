package hwork12;

import java.io.*;

public class HW2 extends HW1 {
    public HW2(File file) {
        setFile(file);
    }

    public void setFile(File file) {
        if (file == null || !file.getName().endsWith("txt") || file.isDirectory()) {
            this.file = new File("default.txt");
        } else {
            this.file = file;
        }
        try {
            if (this.file.createNewFile()) {
                System.out.println(this.file.getName() + " создан");
            } else {
                System.out.println(this.file.getName() + " уже существует");
            }
        } catch (IOException e) {
            System.out.println(" Файл не создан" + e.getMessage());
        }
    }

    @Override
    public boolean writeToFile(byte[] data) {
        boolean result = false;
        String pKey = "Это ключ";
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            byte[] key = pKey.getBytes();
            byte[] res = new byte[data.length];

            for (int i = 0; i < data.length; i++) {
                res[i] = (byte) (data[i] ^ key[i % key.length]);
            }
            outputStream.write(res);
            result = true;
        } catch (FileNotFoundException e) {
            System.out.println(" Файл не был найден");
        } catch (IOException e) {
            System.out.println(" Ошибка записи в файл");
        }
        return result;
    }

    @Override
    public byte[] readFromFile() {
        byte[] result = null;
        String pKey = "Это ключ";
        try (FileInputStream fileImput = new FileInputStream(file);
             ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {
            byte[] res = new byte[555];
            byte[] key = pKey.getBytes();
            int readCount;
            while ((readCount = fileImput.read(res)) != -1) {
                //не понимаю какие данные приходят на вход readFromFile
                //по сути ничего не приходит, но как получить массив который мы будем передавать в текстовый файл
                //
                for (int i = 0; i < file.length(); i++) {
                    res[i] = (byte) (data[i] ^ key[i % key.length]);
                }
                byteArray.write(res, 0, readCount);
            }
            result = byteArray.toByteArray();
        } catch (FileNotFoundException e) {
            System.out.println(" Файл не был найден");
        } catch (IOException e) {
            System.out.println(" Ошибка чтения в файл");
        }
        return result;
    }
}

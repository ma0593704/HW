package second_exam;

import java.io.*;
import java.sql.Array;
import java.util.Arrays;


public class SaveAndLoad extends FileLoadAndSave {
    public SaveAndLoad(File file) {
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
    public boolean writeToFile(byte[] data) throws IOException {
        boolean result = false;
        try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
            outputStream.write(data);
            result = true;
        } catch (FileNotFoundException e) {
            System.out.println(" Файл не был найден");
        } catch (IOException e) {
            System.out.println(" Ошибка записи в файл");
        }
        return result;

    }

    @Override
    public byte[] readFromFile() throws IOException {
        byte[] result = null;
        try (FileInputStream fileImput = new FileInputStream(file);
             ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {
            byte[] buf = new byte[512];
            int readCount;
            while ((readCount = fileImput.read(buf)) != -1) {
                byteArray.write(buf, 0, readCount);
            }
            result = byteArray.toByteArray();
            String b = new String(result);

            System.out.println(b);
        } catch (FileNotFoundException e) {
            System.out.println(" Файл не был найден");
        } catch (IOException e) {
            System.out.println(" Ошибка чтения в файл");
        }
        return result;
    }
}

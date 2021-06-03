package second_exam;

import java.io.File;
import java.io.IOException;

abstract public class FileLoadAndSave {
    protected File file;

    abstract public boolean writeToFile(byte[] data)throws IOException;
    abstract public byte[] readFromFile()throws IOException;
}

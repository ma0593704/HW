package hwork12;

import java.io.File;


abstract public class HW1 {
    protected File file;

    abstract public boolean writeToFile(byte[] data);
    abstract public byte[] readFromFile();


}

package utils;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public final static String FILE_PATH = "src/main/java/dao/";


    public static void createNewFile(String fileName) throws IOException {
        File file = new File(FILE_PATH+fileName);
        file.createNewFile();
    }

}

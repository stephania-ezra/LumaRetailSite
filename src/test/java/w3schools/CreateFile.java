package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static Logger log = LogManager.getLogger(CreateFile.class);

    public static void main(String[] args) {
        File f = new File("C:\\Users\\steph\\JavaLearning\\Collins.txt");
        try {
            if (f.createNewFile()) {
                log.info("File Created:{}", f.getName());
            } else {
                log.info("File already exists");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
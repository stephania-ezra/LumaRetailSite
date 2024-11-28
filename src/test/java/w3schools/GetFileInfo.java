package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class GetFileInfo {
    public static Logger log = LogManager.getLogger(ReadFile.class);

    public static void main(String[] args) {
        File f = new File("C:\\Users\\steph\\JavaLearning\\Collins.txt");
        if (f.exists()) {
            log.info("File Name is:{}", f.getName());
            log.info("Absolute Path is:{}", f.getAbsolutePath());
            log.info("Writeable:{}", f.canWrite());
            log.info("Readable:{}", f.canRead());
            log.info("File Size is:{}", f.length());
        } else {
            log.info("File does not exists");
        }
    }
}

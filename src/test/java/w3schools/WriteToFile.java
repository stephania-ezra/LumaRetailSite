package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static Logger log = LogManager.getLogger(WriteToFile.class);

    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\steph\\JavaLearning\\Collins.txt");
            fw.write("Happy to see myself writing in a file :)");
            fw.close();
            log.info("Successfully wrote to the file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

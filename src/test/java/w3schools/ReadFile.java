package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static Logger log = LogManager.getLogger(ReadFile.class);

    public static void main(String[] args) {
        File myFile = new File("C:\\Users\\steph\\JavaLearning\\Collins.txt");
        try {
            Scanner sc = new Scanner(myFile);
            if (sc.hasNextLine()) {
                String str = sc.nextLine();
                log.info(str);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

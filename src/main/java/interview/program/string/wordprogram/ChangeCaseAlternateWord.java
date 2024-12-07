package interview.program.string.wordprogram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChangeCaseAlternateWord {
    public static Logger log = LogManager.getLogger(CreateNewString.class);

    String s = "my son ethan";
    String w = s + ' ';
    String word = "";
    String newString = "";
    int count = 0;

    public static void main(String[] args) {
        ChangeCaseAlternateWord ccaw = new ChangeCaseAlternateWord();
        ccaw.changeCaseAlternate();
    }

    void changeCaseAlternate() {
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if (c != ' ') {
                word += c;
            } else {
                //log.info(count); // first word count is zero
                if (count++ % 2 == 0) {
                    newString = newString + word.toUpperCase() + " ";
                } else {
                    newString = newString + word.toLowerCase() + " ";
                }
                word = "";
            }
        }
        log.info("New String is:{}", newString);
    }
}
/**
 * 1st time run
 * *************
 * c is m , so word = m
 * now c is y , so word = my
 * now next is space, here count = 0, 0%2 is 0 then new string will be null+MY+null = MY
 * now new string is MY  and word becomes null.
 * increase the count , now c is s , so word = s;
 * increase the count , now c is o , so word = so;
 * increase the count , now c is n , so word = son;
 * now next is space, here ,now count = 1 1%2 not equal to 0 then new string will be null+so+null=so
 */
package interview.program.string.wordprogram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChangeCaseOfAlternateWords {
    public static Logger log = LogManager.getLogger(CreateNewString.class);

    public static void main(String[] args) {
        ChangeCaseOfAlternateWords ccaw = new ChangeCaseOfAlternateWords();
        ccaw.changeCaseAlternate();
    }

    void changeCaseAlternate() {
        String s = "my son ethan";
        log.info("Given String is:{}", s);

        //String w = s + ' ';
        s += ' ';
        String word = "";
        String newString = "";
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
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
        log.info("Case Changed In Alternate Words:{}", newString);
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
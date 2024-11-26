package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExLearning {
    public static Logger log = LogManager.getLogger(RegExLearning.class);

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[abc]",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("'d' for dog");
        boolean matchFound = matcher.find();
        if(matchFound){
            log.info("Match found");
        }else{
            log.info("No match");
        }
    }
}

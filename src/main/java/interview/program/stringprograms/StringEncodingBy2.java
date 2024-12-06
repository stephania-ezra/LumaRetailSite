package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringEncodingBy2 {
    public static Logger log = LogManager.getLogger(StringEncodingBy2.class);

    String s = "SIMPLY";
    String enc = "";
    void charEncoding(){
        for ( int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            if ( c == 'z'|| c == 'y'|| c == 'Y' || c =='Z'){
                c-=26;
            }else{
                c+=2;
                enc =enc + c;
            }
        }
        log.info(enc);
    }
    public static void main(String[] args) {

        StringEncodingBy2 seb2 = new StringEncodingBy2();
        seb2.charEncoding();
    }
}

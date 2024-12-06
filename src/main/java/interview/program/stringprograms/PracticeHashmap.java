package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class PracticeHashmap {

    public static Logger log = LogManager.getLogger(PracticeHashmap.class);

    HashMap<Character,Integer> countMap = new HashMap<Character,Integer>();
    String s = "tttt";

    void countCharacter(){
      char[] charArray = s.toCharArray();
      for (char key : charArray){
          if(countMap.containsKey(key)){
              countMap.put(key,countMap.get(key)+1);
          }else{
              countMap.put(key,1);
          }
      }
        log.info("Hashmap is:{}", countMap);
    }

    public static void main(String[] args) {
        PracticeHashmap ph = new PracticeHashmap();
        log.info("Given String is:{}", ph.s);
        ph.countCharacter();
    }
}

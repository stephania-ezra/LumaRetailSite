package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorRemove {
    public static Logger log = LogManager.getLogger(IteratorRemove.class);

    public static void main(String[] args) {

        ArrayList<Integer> myNumbers = new ArrayList<Integer>();

        myNumbers.add(11);
        myNumbers.add(12);
        myNumbers.add(21);
        myNumbers.add(14);
        myNumbers.add(23);

        Iterator<Integer> it = myNumbers.iterator();
        while (it.hasNext()){
          Integer i =  it.next();
          if (i < 20){
              it.remove();
          }
        }
        log.info(myNumbers);
    }
}

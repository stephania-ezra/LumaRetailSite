package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * 1. Thread can be created by extending Thread class
 * 2.Thread can be created by implementing Runnable interface
 *
 */
public class ThreadLearning extends Thread{

    public static Logger log = LogManager.getLogger(ThreadLearning.class);

    public static void main(String[] args) {

        ThreadLearning tl = new ThreadLearning();
        tl.start();
        log.info("This code is outside of the thread");
    }

    public void run(){
        log.info("This code is running in a thread");
    }
}

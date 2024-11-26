package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// implementing Runnable interface
public class ThreadLearn implements Runnable {

    public static Logger log = LogManager.getLogger(ThreadLearn.class);

    public static void main(String[] args) {

        ThreadLearn tl = new ThreadLearn();
       Thread thread = new Thread(tl);
        thread.start();
        log.info("This code is outside of the thread");
    }

    @Override
    public void run() {
        log.info("This code is running in a thread");
    }
}

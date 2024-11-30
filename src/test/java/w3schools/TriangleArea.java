package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Triangle{
    public static Logger log = LogManager.getLogger(Triangle.class);
    int length =10;
    int breadth =5 ;

    public void area() {
        int area = length * breadth;
        log.info("area is{}", area);
    }
}

public class TriangleArea {
    public static Logger log = LogManager.getLogger(LoopThroughArrayList.class);

    public static void main(String[] args) {
        Triangle t = new Triangle();
        log.info(t.length);
        log.info(t.breadth);
        t.area();
    }
}


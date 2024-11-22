package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MaximumAndMinimum {

    public static Logger log = LogManager.getLogger(MaximumAndMinimum.class);


    //maximum value in a array
   /* public static void main(String[] args) {
        int[] a = {50, 40, 60, 80, 10, 20, 30};
        //assume first element is maximum

        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        log.info("Maximum element in the array is:{}", max);
    }*/

    //minimum value in a array
    public static void main(String[] args) {

        int[] a = {50, 40, 60, 80, 10, 20, 30};
        //assume first element is minimum

        int min = a[0];
        for ( int i = 1 ; i < a.length ; i++){
            //check with darli , if I give i <= a.length then
            //array index out of bounds exception will come
            if (a[i] < min){
                min = a[i];
            }
        }
        log.info("Minimum value is:{}", min);
    }
}

// <-------Maximum element workflow ------>
// 1. assume max = 50;
//2. 40>50 -> false , if will not be executed , go for the next variable
// 3. 60>50 -> true , 60 = max
// 4. 80>60 -> true , 80 = max
// 5. 10>80 -> false if will not be executed go for next variable
//6. 20> 80 -> false if will not be executed go for next variable
//7. 30>80 -> false if will not be executed go for next variable

// <-------------Minimum element workflow------>
// 1. assume min = 50
//2. 40<50 --> true , min is 40
//3.60<40 --> false 
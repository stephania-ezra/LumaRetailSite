package interview.program.linear.search;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 * creating a method find() in Linear search class
 * creating another class Demo inside this same class
 * not a good practice to do like this
 * so writing class demo in another class file
 */
/*class Demo {
    public static int find(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}*/

public class LinearSearch {
    public static Logger log = LogManager.getLogger(LinearSearch.class);

    public static void main(String[] args) {

        //One Dimensional array
        //int[] arr = {1, 3, 5, 7, 9, 2, 4};
        //LinearClassCont lcc = new LinearClassCont();
        //calling static method
        // classname.method
        //log.info(LinearClassCont.find(arr, 7)); // 2 ans is correct

        // log.info(LinearClassCont.find(arr, 14)); // -1 ; element 14 is not available

        //log.info(LinearClassCont.contains(arr, 7)); // true ans is correct

        //Searching in String
        //*********************
        String name = "Stephania";
        //log.info(LinearClassCont.find(name, 'S')); // 0 ans is correct , S is in 0 position

        //log.info(LinearClassCont.find(name, 'k')); // -1 ; k is not in the

        //log.info(LinearClassCont.contains(name, 'k')); // false

        //log.info(LinearClassCont.contains(name, 'i')); // false


        //two Dimensional array
        int[][] twoDArr = new int[][]{
                {2, 5, 3},
                {5, 7, 8},
                {8, 3, 2}
        };

        int[] result = LinearClassCont.find(twoDArr, 7); // [1,1] ans is correct
        log.info(Arrays.toString(result));

        // twoDArr may also be like {2,5,3},
        //                          {5,7,3,8,9}
        //                          {8,3,2}
    }
}
// Best case -> O(1) ie target element is at the first position
// worst case -> O(n)  n -> input size ie target element is not present at the array . loop needs to search
// through the entire array to find the target.



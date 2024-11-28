package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class BubbleSort {
    public static Logger log = LogManager.getLogger(BubbleSort.class);

    public static void main(String[] args) {
        int[] arr = {22, 10, 14, 13, 6, 17};
        int[] j;

        BubbleSort b = new BubbleSort();
        bubbleSort(arr);
        log.info(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}


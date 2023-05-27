package pack;

import divide_conquer.Exe1;
import divide_conquer.Exe2;

import java.util.Arrays;

/**
 * Demo class is the class for main method.
 * <p>
 *
 * @author Frank Xiao
 */
public class Demo {
    /**
     * Method main is for testing all the functions I wrote in my homework.
     *
     * @param args command line arguments, with little use
     * @author Frank Xiao
     */
    public static void main(String[] args) {
        int[] result = Exe1.MergeSort(new int[]{2, 9, 7, 3, 1, 0, 12, 8});
        System.out.println(Arrays.toString(result));
        int index = Exe1.BinarySearch(result, 2);
        System.out.println("index = " + index);
        int select = Exe1.Select(new Integer[]{2, 9, 7, 3, 1, 0, 12, 8}, 5);
        System.out.println("select = " + select);
//        -----------------------------------------------------
        int sum = Exe2.MaxSubSum(new int[]{-2, 11, -4, 13, -5, -2});
        System.out.println("sum = " + sum);
        sum = Exe2.MaxSubSum(new int[]{-6, 2, 4, -7, 5, 3, 2, -1, 6, -9, 10, -2});
        System.out.println("sum = " + sum);
    }
}

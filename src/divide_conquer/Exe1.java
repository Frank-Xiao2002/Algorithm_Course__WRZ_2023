package divide_conquer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Exe1 is for exercise1.
 * <p>
 * The question is as follows:<br>
 * 实现归并排序、二分查找、基于快排思想的选择算法。（Java or Python）<br>
 *
 * @author Frank_Xiao
 */
public class Exe1 {
    /**
     * Sort the array in ascending order using merge sort.
     *
     * @param arr array to be sorted
     * @return a sorted array in ascending order
     */
    public static int[] MergeSort(int[] arr) {
        if (arr.length <= 1)
            return arr;
        int[] a1 = Arrays.copyOfRange(arr, 0, arr.length / 2), a2 = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        a1 = MergeSort(a1);
        a2 = MergeSort(a2);
        return Merge(a1, a2);
    }

    /**
     * Merge two arrays into one array in ascending order.
     *
     * @param a1 the 1st array
     * @param a2 the 2nd array
     * @return the merged array
     */
    private static int[] Merge(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        int i = 0, j = 0, x;
        for (x = 0; x < a1.length + a2.length && i < a1.length && j < a2.length; x++) {
            int tmp = Math.min(a1[i], a2[j]);
            if (tmp == a1[i])
                i++;
            else
                j++;
            result[x] = tmp;
        }
        while (i != a1.length || j != a2.length) {
            if (i == a1.length) {
                result[x++] = a2[j++];
            } else {
                result[x++] = a1[i++];
            }
        }
        return result;
    }

    /**
     * Searches the specified array of ints for the specified value using the binary search algorithm.
     * The array must be sorted prior to making this call.
     * If it is not sorted, the results are undefined.
     * If the array contains multiple elements with the specified value, there is no guarantee which one will be found.
     *
     * @param arr the array to be searched
     * @param key the value to be searched
     * @return index of the search key, if it is contained in the array; otherwise -1.
     */
    public static int BinarySearch(int[] arr, int key) {
        int index = -1, i = 0, j = arr.length - 1;
        while (i <= j) {
            if (arr[(i + j) / 2] == key) {
                index = (i + j) / 2;
                break;
            }
            if (arr[(i + j) / 2] > key) {
                j = (i + j) / 2 - 1;
            } else {
                i = (i + j) / 2 + 1;
            }
        }
        return index;
    }

    /**
     * Find the kth smallest element in an array.
     *
     * @param arr the array to be searched
     * @param k   the kth smallest
     * @return the kth smallest element in the array
     */
    public static int Select(Integer[] arr, int k) {
        assert (k <= arr.length) && k > 0;
        ArrayList<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {//set arr[0] as the pivot
            if (arr[i] <= arr[0])
                list1.add(arr[i]);//add smaller elements to list1
            else
                list2.add(arr[i]);//add greater elements to list2
        }
        if (k == list1.size() + 1)
            return arr[0];
        Integer[] tmp = new Integer[1];
        if (k <= list1.size()) {
            tmp = list1.toArray(tmp);
            return Select(tmp, k);
        } else {
            tmp = list2.toArray(tmp);
            return Select(tmp, k - 1 - list1.size());
        }
    }
}

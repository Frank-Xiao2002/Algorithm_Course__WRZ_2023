package divide_conquer;

import java.util.Arrays;

/**
 * Exe2 is for exercise2.
 * <p>
 * The question is as follows:<br>
 * 给定一个有n（n≥1）个整数的序列，要求求出其中最大连续子序列的和。（分治策略求解， Java or Python）<br>
 * 例如：<br>
 * 序列（-2，11，-4，13，-5，-2）的最大子序列和为20<br>
 * 序列（-6，2，4，-7，5，3，2，-1，6，-9，10，-2）的最大子序列和为16。<br>
 * 规定一个序列最大连续子序列和至少是0，如果小于0，其结果为0。<br>
 */
public class Exe2 {
    /**
     * Find the maximum sum of an array's sub-array.
     *
     * @param arr the array to be found
     * @return the maximum sum of the array's sub-array
     */
    public static int MaxSubSum(Integer[] arr) {
        if (arr.length <= 1)
            return Math.max(0, arr[0]);

        Integer[] left = Arrays.copyOfRange(arr, 0, arr.length / 2), right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        int leftMax = MaxSubSum(left);
        int rightMax = MaxSubSum(right);
        int r = 0, l = 0, tmp = 0;
        for (int i = arr.length / 2 + 1; i < arr.length; i++) {
            if (tmp + arr[i] > r) {
                r = tmp + arr[i];
            }
            tmp += arr[i];
        }
        tmp = 0;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            if (tmp + arr[i] > l)
                l = tmp + arr[i];
            tmp += arr[i];
        }
        int middleMax = arr[arr.length / 2] + l + r;

        return Math.max(middleMax, Math.max(leftMax, rightMax));
    }
}

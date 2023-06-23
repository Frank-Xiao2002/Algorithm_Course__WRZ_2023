package backtrack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Exe1 is for exercise1.
 * <p>
 * The question is as follows:<br>
 * 找出所有相加之和为n的k个数的组合。组合中只允许含有1-9的正整数，并且每种组合中不存在重复的数字。
 * （说明：所有数字都是正整数。解集不能包含重复的组合。）
 *
 * @author Frank_Xiao
 */
public class Exe1 {
    private static ArrayList<Integer[]> result = new ArrayList<>();
    private static ArrayList<Integer> tmp = new ArrayList<>();


    /**
     * Find all possible combinations of integer between 1 and 9 (both inclusive) so that
     * the sum of these numbers is n and there are total k integers in this sum.
     * <br>
     * The integers used must be different.
     *
     * @param k number of the integers
     * @param n sum of the integers
     */
    public static void FindSum(int k, int n) {
        if (k <= 0 || k >= 10 || n <= 0) throw new AssertionError();
        result.clear();
        tmp.clear();
        back(n, 0, k, 1);
        System.out.println(Arrays.deepToString(result.toArray()));
    }

    /**
     * A recursive approach to search through the result tree.
     *
     * @param targetSum  target sum
     * @param currentSum current sum
     * @param k          total number of used integers
     * @param start      starting number for the following calculation, i.e., number of the root
     */
    private static void back(int targetSum, int currentSum, int k, int start) {
        if (tmp.size() == k) {
            if (currentSum == targetSum) {
                Integer[] arr = {};
                arr = tmp.toArray(arr);
                result.add(arr);
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (currentSum + i > targetSum) break;
            currentSum += i;
            tmp.add(i);
            back(targetSum, currentSum, k, i + 1);
            currentSum -= i;
            tmp.remove(tmp.size() - 1);
        }
    }

}




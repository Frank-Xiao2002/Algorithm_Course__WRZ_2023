package backtrack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Exe2 is for exercise2.
 * <p>
 * The question is as follows:<br>
 * 如图m*n方格矩阵a[m][n]中摆放着价值不等的宝贝（价值可正可负），
 * 从左上角a[0][0]出发到达右下角a[m-1][n-1]，可以向右或向下走到相邻格子，
 * 并捡起当前格子的宝贝（无论价值的正负），每个格子只能走一遍。
 * 求能捡到宝贝价值之和的最大值。<br>
 */
public class Exe2 {
    private static int m;//4
    private static int n;//5
    private static int[][] map;
    private static int result = Integer.MIN_VALUE;
    private static Integer[] minPath;
    private static ArrayList<Integer> list = new ArrayList<>();

    /**
     * Find the path with maximum value following
     *
     * @param map a two-dimensional array storing each position's value, acting as a map to go
     */
    public static void findMaxRoute(int[][] map) {
        if (!checkMap(map)) throw new AssertionError();
        list.clear();
        m = map.length;
        n = map[0].length;
        minPath = new Integer[m + n - 1];
        minPath[0] = map[0][0];
        minPath[m + n - 2] = map[m - 1][n - 1];
        Exe2.map = map;
        back(0, 0, 0, 0);
        System.out.println("result = " + result + ", path is " + Arrays.toString(minPath));
    }

    /**
     * Check if the map's size is appropriate.
     *
     * @param map the map
     * @return true is the map is legal, false otherwise
     */
    private static boolean checkMap(int[][] map) {
        int length = map[0].length;
        for (int i = 1; i < map.length; i++) {
            if (map[i].length != length)
                return false;
        }
        return true;
    }

    /**
     * Key part to search through the tree with DFS strategy.
     *
     * @param x    x coordinate
     * @param y    y coordinate
     * @param step the step at present
     */
    private static void back(int x, int y, int step, int sumTmp) {
        if (step == m + n - 2) {
            list.add(map[m - 1][n - 1]);
            sumTmp += map[m - 1][n - 1];
            /*it's the last step of the path, record the path if necessary*/
            if (sumTmp > result) {
                result = sumTmp;
                list.toArray(minPath);
            }
            list.remove(list.size() - 1);
            return;
        }
        /*search two directions*/
        /*go down first*/
        if (x + 1 < m) {
            list.add(map[x][y]);//append the number
            back(x + 1, y, step + 1, sumTmp + map[x][y]);
            list.remove(list.size() - 1);//pop the last element
        }
        /*go right second*/
        if (y + 1 < n) {
            list.add(map[x][y]);
            back(x, y + 1, step + 1, sumTmp + map[x][y]);
            list.remove(list.size() - 1);
        }
    }
}

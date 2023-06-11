package dynamic;

import java.util.Arrays;

/**
 * Exe2 is for exercise2.
 * <p>
 * The question is as follows:<br>
 * 给定一个，包含非负整数的m*n网格。请找出一条，从左上角到右下角的路径。使得路径上，所有数字总和为最小。每次只能向下，或者向右移动一步。
 * 输入示例:<br>
 * [[1,3,1],<br>
 * [1,5,1],<br>
 * [4,2,1]]<br>
 * 输出: 7
 */
public class Exe2 {

    /**
     * Starting from the up-left point of a rectangular graph, a man can go either right or down.
     * Every time he passes a square, the cost of the route increases by the value of the square.
     * This method finds the minimum cost of the route to reach the down-right point of the graph.
     *
     * @param graph a two-dimensional integer array storing the cost of passing each square
     * @return the minimum cost of the route
     */
    public static int getMinRoute(int[][] graph) {
        for (int i = 0; i < graph.length - 1; i++)
            if (graph[i].length != graph[i + 1].length)
                throw new AssertionError();
        int m = graph.length, n = graph[0].length;
        int[][] mins = new int[m][n];
        char[][] route = new char[m][n];

        route[0][0] = '*';
        mins[0][0] = graph[0][0];
        for (int s = 1; s <= m + n - 2; s++) {//s means sum
            int i, j;
            if (s > n - 1) {
                j = n - 1;
                i = s - j;
            } else {
                i = 0;
                j = s - i;
            }
            for (; i < m && j >= 0 && i >= 0 && j < n; i++, j--) {
                /*i and j is the position of the square to be calculated*/
                int vup = valueOf(i - 1, j, mins), vlf = valueOf(i, j - 1, mins);
                int min = Math.min(vup, vlf);
                mins[i][j] = min + graph[i][j];
                route[i][j] = min == vup ? 'u' : 'l';
            }
        }
        /*print out the route*/
        System.out.println("Route:");
        printRoute(route, m - 1, n - 1);
        System.out.println();
        return mins[m - 1][n - 1];
    }

    /**
     * Virtually add an edge to the up and left side of the graph and return the value of each square.
     *
     * @param x   x position of the square
     * @param y   y position of the square
     * @param arr graph to be searched
     * @return Integer.MAX_VALUE if the position doesn't exist, otherwise the real value stored in the array
     */
    private static int valueOf(int x, int y, int[][] arr) {
        assert x < arr.length && y < arr[0].length;
        if (x < 0 || y < 0)
            return Integer.MAX_VALUE;
        return arr[x][y];
    }

    /**
     * print out the route according to the route array
     *
     * @param route an array storing the route
     * @param x     x coordinate of the destination
     * @param y     y coordinate of the destination
     */
    private static void printRoute(char[][] route, int x, int y) {
        if (x == 0 && y == 0)
            System.out.print("(0,0)");
        else {
            if (route[x][y] == 'u')
                printRoute(route, x - 1, y);
            else
                printRoute(route, x, y - 1);
            System.out.print("-(" + x + "," + y + ")");
        }
    }
}

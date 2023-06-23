package backtrack;

/**
 * Demo class is the class for the main method.
 *
 * @author Frank Xiao
 */
public class Demo {
    /**
     * main method for testing homework
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Exe1.FindSum(3, 7);
        Exe1.FindSum(3, 9);

        int[][] map = {
                {2, -1, 6, -2, 6},
                {-3, 2, 5, -5, 1},
                {4, 8, 3, -2, 4},
                {5, 2, 8, -4, 7}};
        Exe2.findMaxRoute(map);
    }
}


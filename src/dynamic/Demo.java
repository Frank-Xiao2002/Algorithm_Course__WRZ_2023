package dynamic;

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
        int[] prices = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 24};
        int mv = Exe1.MaxValueOfStick(10, prices);
        System.out.println("Max value of the stick is " + mv);
        System.out.println("----------------------------");
        int[][] graph = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int min = Exe2.getMinRoute(graph);
        System.out.println("minimum route costs: " + min);
    }
}

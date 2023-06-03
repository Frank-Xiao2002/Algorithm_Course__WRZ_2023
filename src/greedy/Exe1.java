package greedy;

import data_structure.AcyclicGraph;
import data_structure.UndirectedAcyclicAcyclicGraph;
import org.jetbrains.annotations.NotNull;

/**
 * Exe1 is for exercise1.
 * <p>
 * The question is as follows:<br>
 * 实现Huffman算法、最大生成树、单源最短路径(SSSP)的Dijkstra算法。（Java or Python）
 *
 * @author Frank_Xiao
 */
public class Exe1 {
    /**
     * Huffman algorithm implementation
     *
     * @param percents an array to store the percentage of each element, e.g., 13 means 13%
     */
    public static void Huffman(int[] percents) {

    }

    /**
     * Kruskal algorithm implementation<br>
     *
     * @param graph the graph to be calculated
     */
    public static void Kruskal(@NotNull UndirectedAcyclicAcyclicGraph graph) {
        int sv = 0, ev = 0;
        //initially, every node is in its own branch
        int[] branch = new int[graph.getTotalNodes()];
        for (int i = 0; i < graph.getTotalNodes(); i++)
            branch[i] = i;

        /* add n-1 edges, one at a time */
        for (int x = 1; x < graph.getTotalNodes(); x++) {
            int small = Integer.MAX_VALUE;
            /* find the smallest edge */
            for (int i = 0; i < graph.getTotalNodes(); i++)
                for (int j = i + 1; j < graph.getTotalNodes(); j++)
                    if (branch[i] != branch[j])//they are in different branches
                        if (graph.hasEdge(i + 1, j + 1))//there IS an edge connecting them
                            if (small > graph.lengthOf(i, j)) {//the edge is smaller than the current value
                                small = graph.lengthOf(i, j);//renew the value
                                /*record the nodes*/
                                sv = i;
                                ev = j;
                            }
            /*renew every node's branch no.*/
            int min = Math.min(branch[sv], branch[ev]), max = Math.max(branch[sv], branch[ev]);
            for (int i = 0; i < graph.getTotalNodes(); i++)
                if (branch[i] == max)
                    branch[i] = min;
            /*print out the selected edge*/
            System.out.println((sv + 1) + "--" + (ev + 1));
        }
    }

    /**
     * Dijkstra algorithm implementation<br>
     *
     * @param graph the graph to be calculated
     * @param start index of the start node, an integer greater than 0
     */
    public static void Dijkstra(AcyclicGraph graph, int start) {
        if (start <= 0 || start >= graph.getTotalNodes() + 1) throw new AssertionError();
        start--;

    }
}

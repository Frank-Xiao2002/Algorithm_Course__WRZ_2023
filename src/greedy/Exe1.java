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
     * @param percents an array to store the percentage of each element
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
        boolean[] used = new boolean[graph.getTotalNodes()];

        for (int x = 1; x < graph.getTotalNodes(); x++) {//add n-1 edges, one at a time
            int small = Integer.MAX_VALUE;
            /* find the smallest edge */
            for (int i = 0; i < graph.getTotalNodes(); i++)
                for (int j = i + 1; j < graph.getTotalNodes(); j++)
                    if (i != j && !(used[i] && used[j]) && graph.hasEdge(i + 1, j + 1) && small > graph.lengthOf(i, j)) {
                        small = graph.lengthOf(i, j);
                        sv = i;
                        ev = j;
                    }
            //check if this would cause cycles
            if (!used[sv] || !used[ev]) {//at least one node hasn't been used
                used[sv] = true;
                used[ev] = true;

                System.out.println((sv + 1) + "--" + (ev + 1));
            }
        }
    }

    /**
     * Dijkstra algorithm implementation
     *
     * @param graph the graph to be calculated
     */
    public static void Dijkstra(AcyclicGraph graph) {

    }
}

package greedy;

import data_structure.UndirectedAcyclicAcyclicGraph;

/**
 * Demo class is the class for the main method.
 * <p>
 *
 * @author Frank Xiao
 */
public class Demo {
    public static void main(String[] args) {
        UndirectedAcyclicAcyclicGraph g = new UndirectedAcyclicAcyclicGraph(8);
        g.addEdge(3, 1, 5);
        g.addEdge(1, 2, 3);
        g.addEdge(3, 4, 12);
        g.addEdge(2, 4, 4);
        g.addEdge(4, 5, 9);
        g.addEdge(4, 8, 8);
        g.addEdge(5, 8, 1);
        g.addEdge(6, 5, 4);
        g.addEdge(6, 7, 6);
        g.addEdge(5, 7, 5);
        g.addEdge(7, 8, 20);
        Exe1.Kruskal(g);
    }
}

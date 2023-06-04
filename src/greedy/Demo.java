package greedy;

import data_structure.UndirectedAcyclicGraph;

import java.util.HashMap;

/**
 * Demo class is the class for the main method.
 * <p>
 *
 * @author Frank Xiao
 */
public class Demo {
    public static void main(String[] args) {
//        UndirectedAcyclicGraph graph = new UndirectedAcyclicGraph(8);
//        graph.addEdge(3, 1, 5);
//        graph.addEdge(1, 2, 3);
//        graph.addEdge(3, 4, 12);
//        graph.addEdge(2, 4, 4);
//        graph.addEdge(4, 5, 9);
//        graph.addEdge(4, 8, 8);
//        graph.addEdge(5, 8, 1);
//        graph.addEdge(6, 5, 4);
//        graph.addEdge(6, 7, 6);
//        graph.addEdge(5, 7, 5);
//        graph.addEdge(7, 8, 20);
//        Exe1.Kruskal(graph);
//        Exe1.Dijkstra(graph, 4);

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 12);
        map.put('b', 2);
        map.put('c', 7);
        map.put('d', 13);
        map.put('e', 14);
        map.put('f', 85);
        Exe1.Huffman(map);
    }
}

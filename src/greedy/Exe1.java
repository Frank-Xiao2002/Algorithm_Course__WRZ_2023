package greedy;

import data_structure.BinaryTree;
import data_structure.UndirectedAcyclicGraph;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

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
     * @param input a hashmap to store the frequency of each element, e.g., ('a',13) means 'a' appears 13 times
     * @return a hashmap storing each character and its path in Huffman tree, which is described in {@link String}
     */
    public static HashMap<Character, String> Huffman(HashMap<Character, Integer> input) {
        ArrayList<BinaryTree> list = new ArrayList<>();
        int x = 0;
        for (char c : input.keySet())
            list.add(new BinaryTree(c, input.get(c)));

        /*merge two nodes one at a time*/
        while (list.size() > 1) {
            BinaryTree n1 = getSmallestFrequency(list);
            list.remove(n1);
            BinaryTree n2 = getSmallestFrequency(list);
            list.remove(n2);
            BinaryTree r = new BinaryTree(null, n1.getFrequency() + n2.getFrequency());
            r.setLeft(n1);
            r.setRight(n2);
            n1.setLor(0);
            n2.setLor(1);
            list.add(r);
        }
        HashMap<Character, String> result = new HashMap<>();
        createHuffmanCode(list.get(0), result);
        return result;
    }

    /**
     * Search through the list and find the node with the smallest frequency
     *
     * @param list list to be found
     * @return a binary tree node with the smallest frequency in the list
     */
    private static BinaryTree getSmallestFrequency(ArrayList<BinaryTree> list) {
        BinaryTree node = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getFrequency() < node.getFrequency()) {
                node = list.get(i);
            }
        }
        return node;
    }

    /**
     * Build the Huffman code with Huffman tree.
     *
     * @param root   root node of the Huffman tree
     * @param result a Hashmap to store results
     */
    private static void createHuffmanCode(BinaryTree root, HashMap<Character, String> result) {
        result.put(root.getCh(), result.get())

    }

    /**
     * Kruskal algorithm implementation<br>
     *
     * @param graph the graph to be calculated
     */
    public static void Kruskal(@NotNull UndirectedAcyclicGraph graph) {
        int sv = 0, ev = 0;
        //initially, every node is in its own branch
        int[] branch = new int[graph.getTotalNodes()];
        for (int i = 0; i < graph.getTotalNodes(); i++)
            branch[i] = i;

        /* add n-1 edges, one at a time */
        System.out.println("Kruskal result:");
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
    public static void Dijkstra(UndirectedAcyclicGraph graph, int start) {
        if (start <= 0 || start >= graph.getTotalNodes() + 1) throw new AssertionError();
        start--;//let start be in range of [0,total-1]
        /*create two hashmaps, one to store distance from start to each node, one to store the last node on the route to each node*/
        HashMap<Integer, Integer> distances = new HashMap<>(), last = new HashMap<>();
        /*create a boolean array to store whether the node has reached or not*/
        boolean[] isCertain = new boolean[graph.getTotalNodes()];
        /*init maps*/
        for (int i = 0; i < graph.getTotalNodes(); i++) {
            distances.put(i, Integer.MAX_VALUE);
            last.put(i, -1);
        }
        distances.put(start, 0);
        last.put(start, start);
        /*find the smallest distance up to now*/
        for (int times = 0; times < graph.getTotalNodes(); times++) {
            int smallNode = -1, smallDist = Integer.MAX_VALUE;
            for (int i = 0; i < graph.getTotalNodes(); i++)
                //find the node that has not been reached and has the shortest distance
                if (!isCertain[i] && distances.get(i) < smallDist) {
                    smallDist = distances.get(i);
                    smallNode = i;
                }
//            System.out.println("smallNode = " + (smallNode + 1));
//            System.out.println("smallDist = " + smallDist);
            isCertain[smallNode] = true;
            /*update info on two maps*/
            HashMap<Integer, Integer> map = graph.getEdgesStartWith(smallNode + 1);
            for (int node : map.keySet()) {
                node--;//to change range
                if (node != last.get(smallNode)) {//don't calculate the calculated route
                    if (distances.get(node) == Integer.MAX_VALUE) {//the node hasn't been reached yet
                        distances.put(node, map.get(node + 1) + distances.get(smallNode));
                        last.put(node, smallNode);
                    } else {//the node has been reached already
                        //compare the old and the newly found route
                        Integer oldDist = distances.put(node, Math.min(distances.get(node), distances.get(smallNode) + map.get(node + 1)));
                        if (oldDist > distances.get(node)) {//the new distance is smaller than the previous one
                            last.put(node, smallNode);//update 'last' map
                        }
                    }
                }
            }
        }
        /*print out result table*/
        System.out.println("Dijkstra result table:");
        System.out.println("Node\tDistance\tlast");
        for (int i = 0; i < graph.getTotalNodes(); i++)
            System.out.println((i + 1) + "\t\t" + distances.get(i) + "\t\t\t" + (last.get(i) + 1));
//        System.out.println(Arrays.toString(isCertain));
    }
}

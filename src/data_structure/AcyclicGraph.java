package data_structure;

/**
 * AcyclicGraph is to describe one kind of the graph abstract data structure.<br>
 * This class represents graphs that have no cycles, thus a two-dimensional array can be
 * used to store length of every edge.<br>
 * It's implemented by two subclasses, {@link UndirectedAcyclicAcyclicGraph},
 * {@link DirectedAcyclicAcyclicGraph}.
 *
 * @author Frank_Xiao
 */
public abstract class AcyclicGraph {
    protected int totalNodes;
    protected int[][] edges;

    /**
     * Build a new graph with the number of nodes.
     *
     * @param totalNodes total number of nodes
     */
    public AcyclicGraph(int totalNodes) {
        this.totalNodes = totalNodes;
        edges = new int[totalNodes][totalNodes];
    }

    /**
     * Get the total number of nodes.
     *
     * @return number of nodes
     */
    public int getTotalNodes() {
        return totalNodes;
    }

    /**
     * Get the length of the specified edge.
     *
     * @param start index of the start node
     * @param end   index of the end node
     * @return length of the edge
     */
    public int lengthOf(int start, int end) {
        return edges[start][end];
    }

    /**
     * Test whether an edge exists between the two nodes
     *
     * @param start index of the start node, greater than 0
     * @param end   index of the end node, greater than 0
     * @return true if there is an edge connecting two nodes, false otherwise
     */
    public boolean hasEdge(int start, int end) {
        return edges[start - 1][end - 1] > 0;
    }

    /**
     * Add an edge to the graph.<br>
     * Depending on different kinds of the graph, it is implemented differently.
     *
     * @param start  index of the start node
     * @param end    index of the end node
     * @param length length of the edge
     */
    public abstract void addEdge(int start, int end, int length);

}

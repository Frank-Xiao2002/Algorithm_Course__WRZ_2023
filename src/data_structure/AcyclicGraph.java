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
     * Get the edges.
     *
     * @return a two-dimensional array representing the edges.
     */
    public int[][] getEdges() {
        return edges;
    }

    /**
     * Add an edge to the graph.<br>
     * Depending on different kinds of the graph, it is implemented differently.
     *
     * @param start  index of the start node
     * @param end    index of the end node
     * @param length length of the edge
     */
    public abstract void setEdge(int start, int end, int length);

}

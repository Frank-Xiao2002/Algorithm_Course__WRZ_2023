package data_structure;

/**
 *
 */
public class DirectedAcyclicGraph extends AcyclicGraph {
    public DirectedAcyclicGraph(int totalNodes) {
        super(totalNodes);
    }

    /**
     * Add an edge to the directed graph.
     *
     * @param start  index of the start node
     * @param end    index of the end node
     * @param length length of the edge
     */
    @Override
    public void addEdge(int start, int end, int length) {
        if (start == end) throw new AssertionError();
        edges[start][end] = length;
    }

    /**
     * Delete an edge in a directed acyclic graph.
     *
     * @param start start node of the edge
     * @param end   end node of the edge
     */
    @Override
    public void deleteEdge(int start, int end) {
        if (start <= 0 || end > totalNodes) throw new AssertionError();
        edges[start][end] = 0;
    }
}

package data_structure;

/**
 *
 */
public class DirectedAcyclicAcyclicGraph extends AcyclicGraph {
    public DirectedAcyclicAcyclicGraph(int totalNodes) {
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
        edges[start][end] = length;
    }
}

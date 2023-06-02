package data_structure;

public class UndirectedAcyclicAcyclicGraph extends AcyclicGraph {
    public UndirectedAcyclicAcyclicGraph(int totalNodes) {
        super(totalNodes);
    }

    /**
     * Add an edge to the undirected graph.
     *
     * @param start  index of the start node
     * @param end    index of the end node
     * @param length length of the edge
     */
    @Override
    public void setEdge(int start, int end, int length) {
        edges[start][end] = length;
        edges[end][start] = length;
    }
}

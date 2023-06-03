package data_structure;

public class UndirectedAcyclicGraph extends AcyclicGraph {
    public UndirectedAcyclicGraph(int totalNodes) {
        super(totalNodes);
    }

    /**
     * Add an edge to the undirected graph.<br>
     * start and end are two positive integers
     *
     * @param start  index of the start node
     * @param end    index of the end node
     * @param length length of the edge
     */
    @Override
    public void addEdge(int start, int end, int length) {
        if (start == end) throw new AssertionError();
        assert start > 0 && end > 0;
        edges[start - 1][end - 1] = length;
        edges[end - 1][start - 1] = length;
    }

    /**
     * Delete an edge in an undirected acyclic graph.
     *
     * @param start start node of the edge
     * @param end   end node of the edge
     */
    @Override
    public void deleteEdge(int start, int end) {
        if (start <= 0 || end > totalNodes) throw new AssertionError();
        edges[start][end] = 0;
        edges[end][start] = 0;
    }
}

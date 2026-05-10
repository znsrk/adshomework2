import java.util.LinkedHashMap;
import java.util.Map;

public class Experiment {
    private final Map<Integer, Result> results;

    public Experiment() {
        this.results = new LinkedHashMap<>();
    }

    public void runTraversals(Graph g, int startVertex, int sizeLabel) {
        long bfsStart = System.nanoTime();
        g.bfs(startVertex);
        long bfsEnd = System.nanoTime();

        long dfsStart = System.nanoTime();
        g.dfs(startVertex);
        long dfsEnd = System.nanoTime();

        results.put(sizeLabel, new Result(bfsEnd - bfsStart, dfsEnd - dfsStart));
    }

    public void runMultipleTests() {
        Graph small = buildGraph(10);
        Graph medium = buildGraph(30);
        Graph large = buildGraph(100);

        small.setPrintTraversal(false);
        medium.setPrintTraversal(false);
        large.setPrintTraversal(false);

        runTraversals(small, 0, 10);
        runTraversals(medium, 0, 30);
        runTraversals(large, 0, 100);
    }

    public void printResults() {
        System.out.println("\nExecution Time (nanoseconds)");
        System.out.println("Vertices | BFS | DFS");
        for (Map.Entry<Integer, Result> entry : results.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue().bfsTime + " | " + entry.getValue().dfsTime);
        }
    }

    private static class Result {
        private final long bfsTime;
        private final long dfsTime;

        private Result(long bfsTime, long dfsTime) {
            this.bfsTime = bfsTime;
            this.dfsTime = dfsTime;
        }
    }

    public static Graph buildGraph(int size) {
        Graph g = new Graph();
        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }
        for (int i = 0; i < size - 1; i++) {
            g.addEdge(i, i + 1);
        }
        for (int i = 0; i < size; i++) {
            int jump = (i + 3) % size;
            g.addEdge(i, jump);
        }
        return g;
    }
}

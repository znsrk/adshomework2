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
}

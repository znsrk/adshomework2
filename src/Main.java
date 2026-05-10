public class Main {
    public static void main(String[] args) {
        Graph small = buildGraph(10);
        small.setPrintTraversal(true);
        System.out.println("Small graph output");
        small.printGraph();
        small.bfs(0);
        small.dfs(0);

        Experiment experiment = new Experiment();

        Graph medium = buildGraph(30);
        medium.setPrintTraversal(false);
        experiment.runTraversals(medium, 0, 30);

        Graph large = buildGraph(100);
        large.setPrintTraversal(false);
        experiment.runTraversals(large, 0, 100);

        experiment.printResults();
    }

    private static Graph buildGraph(int size) {
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

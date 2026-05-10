public class Main {
    public static void main(String[] args) {
        Graph small = Experiment.buildGraph(10);
        small.setPrintTraversal(true);
        System.out.println("Small graph output");
        small.printGraph();
        small.bfs(0);
        small.dfs(0);

        Experiment experiment = new Experiment();

        Graph medium = Experiment.buildGraph(30);
        medium.setPrintTraversal(false);
        experiment.runTraversals(medium, 0, 30);

        Graph large = Experiment.buildGraph(100);
        large.setPrintTraversal(false);
        experiment.runTraversals(large, 0, 100);

        experiment.printResults();
    }
}

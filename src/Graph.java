import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
    private final Map<Integer, Vertex> vertices;
    private final Map<Integer, List<Integer>> adjacencyList;
    private boolean printTraversal;

    public Graph() {
        this.vertices = new HashMap<>();
        this.adjacencyList = new HashMap<>();
        this.printTraversal = false;
    }

    public void setPrintTraversal(boolean value) {
        this.printTraversal = value;
    }

    public void addVertex(Vertex v) {
        if (!vertices.containsKey(v.getId())) {
            vertices.put(v.getId(), v);
            adjacencyList.put(v.getId(), new ArrayList<>());
        }
    }

    public void addEdge(int from, int to) {
        if (!vertices.containsKey(from)) {
            addVertex(new Vertex(from));
        }
        if (!vertices.containsKey(to)) {
            addVertex(new Vertex(to));
        }
        adjacencyList.get(from).add(to);
        adjacencyList.get(to).add(from);
    }

    public void printGraph() {
        System.out.println("Adjacency List:");
        for (int v : adjacencyList.keySet()) {
            System.out.print(v + " -> ");
            List<Integer> neighbors = adjacencyList.get(v);
            for (int i = 0; i < neighbors.size(); i++) {
                System.out.print(neighbors.get(i));
                if (i < neighbors.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    public void bfs(int start) {
        if (!vertices.containsKey(start)) {
            return;
        }
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();
        List<Integer> order = new ArrayList<>();

        visited.add(start);
        queue.add(start);

        // BFS explores neighbors layer by layer using a queue.
        while (!queue.isEmpty()) {
            int current = queue.remove();
            order.add(current);
            for (int neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        if (printTraversal) {
            System.out.println("BFS order: " + order);
        }
    }

    public void dfs(int start) {
        if (!vertices.containsKey(start)) {
            return;
        }
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> order = new ArrayList<>();

        stack.push(start);

        // DFS explores depth first using a stack to drive backtracking.
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);
                order.add(current);
                List<Integer> neighbors = adjacencyList.get(current);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int neighbor = neighbors.get(i);
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        if (printTraversal) {
            System.out.println("DFS order: " + order);
        }
    }
}

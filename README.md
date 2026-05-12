Project overview
This project builds an undirected graph using an adjacency list where each vertex stores a list of its neighbors. Vertices are numbered 0 to n-1 and edges connect pairs of vertices. BFS and DFS both start from a chosen start vertex and visit reachable vertices while tracking a visit order. BFS uses a queue to expand level by level while DFS uses recursion or a stack to go as deep as possible first.

Class descriptions
Vertex holds an id and its adjacency list of neighbor vertices. Edge stores a connection between two vertices so the graph can add undirected links. Graph stores all vertices and edges and exposes methods to add edges plus run BFS and DFS using the adjacency list representation.

Algorithm descriptions
BFS steps go like this start with the source, mark it visited, push it into a queue, then pop from the queue, visit its neighbors, and keep expanding until the queue is empty. BFS use cases include shortest path in unweighted graphs and level order exploration. Time complexity is O(V + E).
DFS steps go like this start with the source, mark it visited, go to the first unvisited neighbor, repeat until you hit a dead end, then backtrack and keep going. DFS use cases include cycle detection, topological style exploration, and connected components. Time complexity is O(V + E).

Experimental results
Execution time comparison table
10 vertices: not measured in this run
30 vertices: BFS 48800 ns, DFS 34700 ns
100 vertices: BFS 212600 ns, DFS 197800 ns
Observations and patterns: times go up as the graph gets bigger and DFS was a bit faster in this run, the difference is small so hardware noise can matter

Screenshots
https://github.com/user-attachments/assets/6d70e705-a877-45d1-a3d4-da90e59469af
https://github.com/user-attachments/assets/6a0019b7-6c5d-49e8-b69c-b0b0d4911a87

Analysis questions
Graph size effect on BFS and DFS performance: both get slower as vertices and edges increase since they touch more nodes and edges
Which traversal is faster in your experiments: DFS was slightly faster for 30 and 100 vertices
Do results match expected complexity O(V + E): yes the growth is consistent with linear work in vertices and edges
How does graph structure affect traversal order: adjacency list order and how edges are added decide which neighbors are visited first so the output order shifts with structure
When is BFS preferred over DFS: when you need shortest path in unweighted graphs or want level by level discovery
Limitations of DFS: it can go deep and blow the stack on large graphs and it does not guarantee shortest paths

Reflection
I learned how traversal affects the search time and how the visit order changes based on graph shape. BFS feels more predictable for shortest paths while DFS is great for digging deep quickly. I faced no challenges in this implementation and the main takeaway is that both scale with V plus E but the actual order depends on the adjacency list

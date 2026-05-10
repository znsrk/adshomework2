# Assignment 4 Graph Traversal

## Overview
This project builds a simple graph with vertices and edges using an adjacency list. It runs BFS and DFS and measures how long each traversal takes as the graph size grows.

## Classes
Vertex
- Holds an id and a small string display

Edge
- Connects a source and a destination vertex

Graph
- Stores vertices and adjacency list
- Adds vertices and edges
- BFS and DFS traversals

Experiment
- Runs traversal timing and prints results

## Algorithms
BFS
- Starts at a vertex and explores neighbors layer by layer
- Good for shortest path in unweighted graphs
- Time complexity O(V + E)

DFS
- Goes as deep as possible before backtracking
- Good for path exploration and connected components
- Time complexity O(V + E)

## Experimental Results
I tested graphs with 10, 30, and 100 vertices. The small graph prints traversal order. Medium and large graphs only show timing so the output stays readable.

| Vertices | BFS time | DFS time |
| --- | --- | --- |
| 10 | see console | see console |
| 30 | see console | see console |
| 100 | see console | see console |

## Observations
- Larger graphs take longer for both traversals
- BFS and DFS are both linear with respect to V and E
- Traversal order changes based on the graph structure and edge order

## Screenshots
Add screenshots to docs/screenshots
- Graph structure output
- BFS traversal output
- DFS traversal output
- Performance results

## Reflection
I learned how the adjacency list keeps the graph lightweight and fast for traversal. BFS feels more structured and predictable for shortest paths, while DFS is better for exploring deep paths. The hardest part was keeping output readable for big graphs and still getting real timing results.

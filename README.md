# Assignment 4 – Graphs

## Description
This project implements BFS, DFS, and Dijkstra for graphs where vertices are objects and store adjacent vertices with weights directly.

## Implemented classes
- Vertex
- WeightedGraph
- UnweightedGraph
- Search
- SearchUtils
- BreadthFirstSearch
- DepthFirstSearch
- DijkstraSearch
- Main

## Main idea
The Edge class was removed.  
Each Vertex stores its neighbors and weights using a map.

## Notes
- BFS and DFS work on UnweightedGraph
- Dijkstra works on WeightedGraph
- The external Main API stays unchanged
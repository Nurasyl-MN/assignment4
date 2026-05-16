import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {
    private UnweightedGraph<V> graph;

    public BreadthFirstSearch(UnweightedGraph<V> graph, V sourceData) {
        this.graph = graph;
        this.source = graph.getVertex(sourceData);
        this.previous = new HashMap<>();
        search();
    }

    private void search() {
        if (source == null) return;

        Map<Vertex<V>, Boolean> visited = new HashMap<>();
        Queue<Vertex<V>> queue = new LinkedList<>();

        for (Vertex<V> vertex : graph.getVertices()) {
            visited.put(vertex, false);
            previous.put(vertex, null);
        }

        visited.put(source, true);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();

                if (!visited.get(neighbor)) {
                    visited.put(neighbor, true);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }

    @Override
    public List<V> pathTo(V destinationData) {
        return buildPath(graph.getVertex(destinationData));
    }
}
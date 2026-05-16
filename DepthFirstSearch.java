import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DepthFirstSearch<V> extends Search<V> {
    private UnweightedGraph<V> graph;

    public DepthFirstSearch(UnweightedGraph<V> graph, V sourceData) {
        this.graph = graph;
        this.source = graph.getVertex(sourceData);
        this.previous = new HashMap<>();
        search();
    }

    private void search() {
        if (source == null) return;

        Map<Vertex<V>, Boolean> visited = new HashMap<>();
        Stack<Vertex<V>> stack = new Stack<>();

        for (Vertex<V> vertex : graph.getVertices()) {
            visited.put(vertex, false);
            previous.put(vertex, null);
        }

        stack.push(source);

        while (!stack.isEmpty()) {
            Vertex<V> current = stack.pop();

            if (!visited.get(current)) {
                visited.put(current, true);

                for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                    Vertex<V> neighbor = entry.getKey();

                    if (!visited.get(neighbor)) {
                        previous.put(neighbor, current);
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    @Override
    public List<V> pathTo(V destinationData) {
        return buildPath(graph.getVertex(destinationData));
    }
}
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraSearch<V> extends Search<V> {
    private WeightedGraph<V> graph;
    private Map<Vertex<V>, Double> distances;

    public DijkstraSearch(WeightedGraph<V> graph, V sourceData) {
        this.graph = graph;
        this.source = graph.getVertex(sourceData);
        this.previous = new HashMap<>();
        this.distances = new HashMap<>();
        search();
    }

    private void search() {
        if (source == null) return;

        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        for (Vertex<V> vertex : graph.getVertices()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
            previous.put(vertex, null);
        }

        distances.put(source, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();

                double newDistance = distances.get(current) + weight;

                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    previous.put(neighbor, current);

                    pq.remove(neighbor);
                    pq.add(neighbor);
                }
            }
        }
    }

    @Override
    public List<V> pathTo(V destinationData) {
        return buildPath(graph.getVertex(destinationData));
    }

    public double distanceTo(V destinationData) {
        Vertex<V> destination = graph.getVertex(destinationData);
        if (destination == null) return Double.POSITIVE_INFINITY;
        return distances.getOrDefault(destination, Double.POSITIVE_INFINITY);
    }
}
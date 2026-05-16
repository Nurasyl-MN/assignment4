import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices;
    private boolean directed;

    public WeightedGraph(boolean directed) {
        this.directed = directed;
        this.vertices = new HashMap<>();
    }

    public Vertex<V> addVertex(V data) {
        vertices.putIfAbsent(data, new Vertex<>(data));
        return vertices.get(data);
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Collection<Vertex<V>> getVertices() {
        return vertices.values();
    }

    public void addEdge(V source, V destination, double weight) {
        Vertex<V> sourceVertex = addVertex(source);
        Vertex<V> destinationVertex = addVertex(destination);

        sourceVertex.addAdjacentVertex(destinationVertex, weight);

        if (!directed) {
            destinationVertex.addAdjacentVertex(sourceVertex, weight);
        }
    }

    public boolean hasVertex(V data) {
        return vertices.containsKey(data);
    }
}
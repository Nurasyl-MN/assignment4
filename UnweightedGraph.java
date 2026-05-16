import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UnweightedGraph<V> {
    private Map<V, Vertex<V>> vertices;
    private boolean directed;

    public UnweightedGraph(boolean directed) {
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

    public void addEdge(V source, V destination) {
        Vertex<V> sourceVertex = addVertex(source);
        Vertex<V> destinationVertex = addVertex(destination);

        sourceVertex.addAdjacentVertex(destinationVertex, 1.0);

        if (!directed) {
            destinationVertex.addAdjacentVertex(sourceVertex, 1.0);
        }
    }

    public boolean hasVertex(V data) {
        return vertices.containsKey(data);
    }
}
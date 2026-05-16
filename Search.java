import java.util.List;
import java.util.Map;

public abstract class Search<V> {
    protected Vertex<V> source;
    protected Map<Vertex<V>, Vertex<V>> previous;

    public abstract List<V> pathTo(V destination);

    protected List<V> buildPath(Vertex<V> destination) {
        return SearchUtils.buildPath(source, destination, previous);
    }
}
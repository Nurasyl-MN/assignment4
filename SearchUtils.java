import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SearchUtils {
    public static <V> List<V> buildPath(Vertex<V> source,
                                        Vertex<V> destination,
                                        Map<Vertex<V>, Vertex<V>> previous) {
        List<V> path = new ArrayList<>();

        if (destination == null) {
            return path;
        }

        Vertex<V> current = destination;

        while (current != null) {
            path.add(current.getData());
            if (current.equals(source)) {
                break;
            }
            current = previous.get(current);
        }

        Collections.reverse(path);

        if (path.isEmpty() || !path.get(0).equals(source.getData())) {
            return new ArrayList<>();
        }

        return path;
    }
}
import java.util.HashMap;

public class Vertex {
    private String name;
    private HashMap<String,Double> edges;

    public Vertex(String name) {
        this.name = name;
        edges = new HashMap<>();
    }

    public HashMap<String, Double> getEdges() {
        return edges;
    }

    public void setEdges(HashMap<String, Double> edges) {
        this.edges = edges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
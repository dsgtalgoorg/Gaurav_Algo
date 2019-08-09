import java.util.ArrayList;
import java.util.List;


class Node {
    boolean isVisited;
    List<Node> child;
    Integer value;

    public Node(Node node, Integer value) {
        if (child == null) {
            child = new ArrayList<Node>();
        }
        child.add(node);
        this.value = value;
    }
}

public class Graph {
    List<Node> adj;

    public Graph(Node node) {
        if (adj == null) {
            adj = new ArrayList<Node>();
        }
        adj.add(node);
    }

    public static void addAdjacent(Node node, Graph g) {
        if (g.adj.isEmpty()) {
            g.adj = new ArrayList<Node>();
        }
        g.adj.add(node);
    }

    public static void printAll(Graph graph) {
        if (graph == null || graph.adj == null) {
            return;
        }
        for (Node node : graph.adj) {
            if (node != null)
                System.out.println("Node  " + node.value);
            for (Node innernode : node.child) {
                if (innernode != null)
                    System.out.println("Child  " + innernode.value);
            }
        }
    }
}
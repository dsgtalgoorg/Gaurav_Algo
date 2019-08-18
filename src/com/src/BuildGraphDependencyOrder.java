import java.util.*;

public class BuildGraphDependencyOrder {

    public static void main(String[] args) {
        Set<Dependency> dependencies = new HashSet<>();
        Set<GraphNode> availableProjects = new HashSet<>();

        GraphNode a = new GraphNode("a");
        GraphNode b = new GraphNode("b");
        GraphNode c = new GraphNode("c");
        GraphNode d = new GraphNode("d");
        GraphNode e = new GraphNode("e");
        GraphNode f = new GraphNode("f");

        availableProjects.addAll(Arrays.asList(a, b, c, d, e, f));
        dependencies.add(new Dependency(a, d));
        dependencies.add(new Dependency(f, b));
        dependencies.add(new Dependency(b, d));
        dependencies.add(new Dependency(f, a));
        dependencies.add(new Dependency(d, c));

        createDependencyGraph(dependencies, availableProjects);
        //System.out.println(finalGraphs.size());
        //  System.out.println(availableProjects.size());

        printAll(availableProjects);
    }

    private static void printAll(Set<GraphNode> availableProjects) {
        List<GraphNode> current = new ArrayList<GraphNode>();
        current.addAll(availableProjects);
        Collections.sort(current);
        Set<GraphNode> parent = new LinkedHashSet<>();
        for (GraphNode node : current) {
            System.out.println(node.name);
            if (node.getAdj() != null)
                parent.addAll(node.getAdj());
        }
        if (parent.size() > 0) {
            printAll(parent);
        }
    }

    private static Set<GraphNode> createDependencyGraph(Set<Dependency> dependencies, Set<GraphNode> availableProjects) {
        Set<GraphNode> finalGraphs = new HashSet<>(1);
        for (Dependency dependency : dependencies) {
            GraphNode parent = dependency.parent;
            GraphNode child = dependency.child;
            if (!finalGraphs.contains(parent)) {
                finalGraphs.add(parent);
                parent.setAdj(new HashSet<>());
            }
            parent.getAdj().add(child);
            availableProjects.remove(child);
        }
        return finalGraphs;
    }
}


class Dependency {
    GraphNode parent;
    GraphNode child;

    public Dependency(GraphNode parent, GraphNode child) {
        this.parent = parent;
        this.child = child;
    }
}


class GraphNode implements Comparable<GraphNode> {

    String name;
    Set<GraphNode> adj;

    public GraphNode(String name) {
        this.name = name;
    }

    public GraphNode(String name, Set<GraphNode> adj) {
        this.name = name;
        this.adj = adj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<GraphNode> getAdj() {
        return adj;
    }

    public void setAdj(Set<GraphNode> adj) {
        this.adj = adj;
    }

    @Override
    public int compareTo(GraphNode graphNode) {
        return this.name.compareTo(graphNode.name);
    }
}

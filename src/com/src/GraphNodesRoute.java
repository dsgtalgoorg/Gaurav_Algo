import java.util.ArrayList;
import java.util.List;

public class GraphNodesRoute {
    public static void main(String[] args) {
        Node parent = new Node(null, 1);
        Graph graph = new Graph(parent);
        Node node2 = new Node(null, 2);
        Node node3 = new Node(null, 3);
        Node node4 = new Node(null, 4);
        Node node5 = new Node(null, 5);
        Node node6 = new Node(null, 6);
        node2.child.add(node4);
        node2.child.add(node5);
        parent.child.add(node3);
        parent.child.add(node2);
        parent.child.add(node6);

        Graph.addAdjacent(node2, graph);
        Graph.addAdjacent(node4, graph);
        Graph.addAdjacent(node3, graph);
        Graph.printAll(graph);

        findPath(node2, node5);
        findPath(node4, node5);
        findPath(parent, node5);

    }

    private static void findPath(Node node2, Node node5) {
        if (node2 == null || node5 == null) return;
        List<Node> list = new ArrayList<Node>();
        list.add(node2);
        boolean isFound = false;
        while (!list.isEmpty() && !isFound) {
            Node node = list.remove(list.size() - 1);
            for (Node n : node.child) {
                if (n != null && !n.isVisited) {
                    if (n == node5) {
                        System.out.println("Found");
                        isFound = true;
                        break;
                    }
                    n.isVisited = true;
                    list.add(n);
                }
            }
        }
        if (!isFound) System.out.println("Not Found");
    }
}

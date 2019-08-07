public class SinglyNode {

    public SinglyNode next;
    public Integer value;

    public SinglyNode() {
    }

    public SinglyNode(Integer value) {
        this.value = value;
    }

    public SinglyNode(SinglyNode next, Integer value) {
        this.next = next;
        this.value = value;
    }

    public static void printList(SinglyNode node) {
        System.out.println("===============================");
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static SinglyNode addLinkedList(SinglyNode node, Integer... values) {
        SinglyNode previousNode = null;
        for (Integer value : values) {
            SinglyNode localNode = new SinglyNode(null, value);
            if (previousNode == null) {
                node.next = localNode;
                previousNode = localNode;
            } else {
                previousNode.next = localNode;
                previousNode = localNode;
            }
        }
        return node;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public SinglyNode getNext() {
        return next;
    }

    public void setNext(SinglyNode next) {
        this.next = next;
    }
}

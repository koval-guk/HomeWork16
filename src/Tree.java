import java.util.*;

public class Tree implements Iterable<Node> {
    private Node root;

    public Tree() {
        root = null;
    }

    public void add(int value) {
        Node node = new Node(value);
        Node tempNode = root;
        Node parentNode;
        if (root == null) {
            root = node;
        } else {
            while (true) {
                parentNode = tempNode;
                if (value == tempNode.getValue()) {
                    return;
                } else if (value < tempNode.getValue()) {
                    tempNode = tempNode.getLeft();
                    if (tempNode == null) {
                        parentNode.setLeft(node);
                        return;
                    }
                } else {
                    tempNode = tempNode.getRight();
                    if (tempNode == null) {
                        parentNode.setRight(node);
                        return;
                    }
                }
            }
        }
    }

    public List<Integer> treeToList(int rootValue) {
        Node tempNode = root;
        List<Integer> tree = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        while (tempNode.getValue() != rootValue) {
            if (rootValue < tempNode.getValue()) {
                tempNode = tempNode.getLeft();
            } else {
                tempNode = tempNode.getRight();
            }
        }
        nodeStack.push(tempNode);
        while (!nodeStack.isEmpty()) {
            Node top = nodeStack.pop();
            tree.add(top.getValue());
            if (top.getRight() != null) {
                nodeStack.push(top.getRight());
            }
            if (top.getLeft() != null) {
                nodeStack.push(top.getLeft());
            }
        }
        return tree;
    }

    public List<Integer> treeToList() {
        return treeToList(root.getValue());
    }

    @Override
    public Iterator<Node> iterator() {
        return new TreeIterator(root);
    }
}

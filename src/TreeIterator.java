import java.util.Iterator;
import java.util.Stack;

public class TreeIterator implements Iterator<Node> {
    private Stack<Node> tree = new Stack<>();

    public TreeIterator(Node root) {
        tree.push(root);
    }

    @Override
    public boolean hasNext() {
        return !tree.isEmpty();
    }

    @Override
    public Node next() {
        Node top = tree.pop();
        if (top.getRight() != null) {
            tree.push(top.getRight());
        }
        if (top.getLeft() != null) {
            tree.push(top.getLeft());
        }
        return top;
    }
}

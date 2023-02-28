public class App {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(5);
        tree.add(4);
        tree.add(7);
        tree.add(8);
        tree.add(1);
        tree.add(6);
        tree.add(9);
        tree.add(3);
        tree.add(2);
        tree.add(10);
        for (Node n:
                tree) {
            System.out.print(n+" ");
        }
        System.out.println();
        System.out.println(tree.treeToList(8));
        System.out.println(tree.treeToList());
    }
}

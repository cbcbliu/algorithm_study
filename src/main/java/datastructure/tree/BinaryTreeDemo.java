package datastructure.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        NodeData node = new NodeData(1, "aaa");
        NodeData node2 = new NodeData(2, "bbb");
        NodeData node3 = new NodeData(3, "vvv");
        NodeData node4 = new NodeData(4, "ccc");
        NodeData node5 = new NodeData(5, "aaaa");
        node.setLeft(node2);
        node.setRight(node3);
        node3.setRight(node4);
        node3.setRight(node5);
        binaryTree.setRoot(node);
        binaryTree.postorder();
    }
}

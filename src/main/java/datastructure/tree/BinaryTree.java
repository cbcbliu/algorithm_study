package datastructure.tree;

public class BinaryTree {

    private NodeData root;

    public void setRoot(NodeData root){
        this.root = root;
    }

    public void preorder(){
        if(this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void inorder(){
        if(this.root != null){
            this.root.inorder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void postorder(){
        if(this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

}

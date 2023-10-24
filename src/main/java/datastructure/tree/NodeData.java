package datastructure.tree;

/**
 * 节点
 */
public class NodeData {

    private int no;//编号
    private String name;
    private NodeData left;
    private NodeData right;

    public NodeData(int no,String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "NodeData{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }

    public void inorder(){
        if(this.left!=null){
            this.left.inorder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.inorder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }
        if (this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NodeData getLeft() {
        return left;
    }

    public void setLeft(NodeData left) {
        this.left = left;
    }

    public NodeData getRight() {
        return right;
    }

    public void setRight(NodeData right) {
        this.right = right;
    }
}

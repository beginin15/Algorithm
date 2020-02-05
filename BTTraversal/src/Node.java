public class Node {
    String key;
    Node leftChild;
    Node rightChild;

    public Node(String key, Node leftChild, Node rightChild) {
        this.key = key;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void setLeftChild(Node leftChild){
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return key;
    }
}

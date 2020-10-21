package baekjoon;

import java.util.LinkedHashMap;
import java.util.Map;

public class N1991 {
    private Map<String, Node> mapTree = new LinkedHashMap<>();

    public Node findNode(String key){
        return mapTree.get(key);
    }

    public void addNode(Node newNode){
        mapTree.put(newNode.key, newNode);
    }

    public void preOrder(Node node){
        if(node != null){
            System.out.print(node.key);
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    public void inOrder(Node node){
        if(node != null){
            inOrder(node.leftChild);
            System.out.print(node.key);
            inOrder(node.rightChild);
        }
    }

    public void postOrder(Node node){
        if(node != null){
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.print(node.key);
        }
    }

    public Node getRoot(){
        Map.Entry<String,Node> entry = mapTree.entrySet().iterator().next();
        return entry.getValue();
    }

    class Node {
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
}

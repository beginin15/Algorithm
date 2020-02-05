import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static BinaryTree tree;

    public static void main(String[] args) {
//        String inputs = "7\n" +
//                "A B C\n" +
//                "B D .\n" +
//                "C E F\n" +
//                "E . .\n" +
//                "F . G\n" +
//                "D . .\n" +
//                "G . .";

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        tree = new BinaryTree();
        try{
            in.readLine();
            splitInputs(in);

            tree.preOrder(tree.getRoot());
            System.out.println();
            tree.inOrder(tree.getRoot());
            System.out.println();
            tree.postOrder(tree.getRoot());
        } catch(IOException e){

        }
    }

    public static void splitInputs(BufferedReader in) throws IOException{
        String line;
        while((line = in.readLine()) != null){
            String[] nodeInfo = line.split(" ");
            createLinks(nodeInfo);
        }
    }

    public static void createLinks(String[] nodeInfo){
        final int PARENT = 0;
        final int LEFT = 1;
        final int RIGHT = 2;

        Node node = tree.findNode(nodeInfo[PARENT]);
        Node leftChild = tree.findNode(nodeInfo[LEFT]);
        Node rightChild = tree.findNode(nodeInfo[RIGHT]);

        if(node == null){
            node = new Node(nodeInfo[PARENT], null, null);
            tree.addNode(node);
        }


        if(leftChild == null){
            leftChild = nodeInfo[LEFT].equals(".") ? null : new Node(nodeInfo[LEFT], null, null);
        }

        if(rightChild == null){
            rightChild = nodeInfo[RIGHT].equals(".") ? null : new Node(nodeInfo[RIGHT], null, null);
        }

        if(leftChild != null){
            tree.addNode(leftChild);
            node.setLeftChild(leftChild);
        }

        if(rightChild != null){
            tree.addNode(rightChild);
            node.setRightChild(rightChild);
        }
    }

}

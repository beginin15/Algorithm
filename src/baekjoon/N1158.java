package baekjoon;

import java.io.*;

public class N1158 {

    private static Node head = new Node(-1, null ,null);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] values = br.readLine().split(" ");
        int size = Integer.parseInt(values[0]);
        int offset = Integer.parseInt(values[1]);

        Node target = head;
        for (int i = 1; i <= size; i++) {
            target.next = createNode(i, target, head);
            target = target.next;
        }

        bw.write("<");
        Node p = head;
        while(size > 0) {
            for (int i = 0; i < offset; i++) {
                p = p.next;
                if (p == head) {
                    p = p.next;
                }
            }
            bw.write(p.data + (size == 1 ? "" : ", "));
            remove(p);
            size--;
        }

        bw.write(">\n");

        bw.close();
        br.close();
    }

    private static Node createNode(int data, Node pre, Node next) {
        Node node = new Node(data, pre, next);
        pre.next = node;
        next.pre = node;
        return node;
    }

    private static void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    static class Node {
        int data;
        Node pre;
        Node next;

        public Node(int data, Node pre, Node next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }
}

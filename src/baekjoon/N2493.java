package baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class N2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];
        Stack<Node> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < count; i++) {
            while (!stack.isEmpty()) {
                if (stack.peek().h < arr[i]) {
                    stack.pop();
                } else {
                    sb.append(stack.peek().index).append(" ");
                    stack.push(new Node(i + 1, arr[i]));
                    break;
                }
            }
            if (stack.isEmpty()) {
                sb.append("0 ");
                stack.push(new Node(i + 1, arr[i]));
            }
        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }

    static class Node {
        int index;
        int h;

        public Node(int index, int h) {
            this.index = index;
            this.h = h;
        }
    }
}

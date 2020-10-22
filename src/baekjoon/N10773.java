package baekjoon;

import java.io.*;
import java.util.Stack;

public class N10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        while (count-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n != 0) {
                stack.push(n);
            } else {
                if (!stack.isEmpty())
                    stack.pop();
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        bw.write(sum + "\n");

        bw.close();
        br.close();
    }
}

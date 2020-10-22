package baekjoon;

import java.io.*;
import java.util.Stack;

public class N1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[count];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= count; i++) {
            stack.push(i);
            sb.append("+\n");

            while (!stack.isEmpty() && stack.peek() == arr[index]) {
                stack.pop();
                sb.append("-\n");
                index++;
            }
        }

        if (!stack.isEmpty()) {
            bw.write("NO\n");
        } else {
            bw.write(sb.toString());
        }

        bw.close();
        br.close();
    }
}

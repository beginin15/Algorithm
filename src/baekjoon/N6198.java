package baekjoon;

import java.io.*;
import java.util.Stack;

public class N6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];

        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < count; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            stack.push(arr[i]);
            result += stack.size() - 1;
        }

        bw.write(result + "\n");
        bw.close();
        br.close();
    }
}

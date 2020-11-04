package baekjoon;

import java.io.*;
import java.util.Stack;

public class N10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        Character before = null;
        int result = 0;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (before == '(') {
                    stack.pop();
                    result += stack.size();
                } else {
                    result += 1;
                    stack.pop();
                }
            }
            before = ch;
        }

        bw.write(result + "\n");
        bw.close();
        br.close();
    }
}

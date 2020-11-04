package baekjoon;

import java.io.*;
import java.util.Stack;

public class N4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = null;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        do {
            boolean flag = false;
            line = br.readLine();
            if (line.equals(".")) {
                break;
            }
            loop: for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                switch (ch) {
                    case '(':
                    case '[':
                        stack.push(ch);
                        break;
                    case ')':
                    case ']':
                        if (stack.isEmpty() ||
                            (stack.peek() != '(' && ch == ')') || (stack.peek() != '[' && ch == ']')) {
                            flag = true;
                            break loop;
                        }
                        stack.pop();
                        break;
                }
            }
            if (flag) {
                sb.append("no\n");
            } else if (stack.isEmpty()) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
            stack.clear();
        } while(true);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}

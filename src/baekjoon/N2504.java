package baekjoon;

import java.io.*;
import java.util.Stack;

public class N2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        Stack<String> stack = new Stack<>();

        int length = line.length();
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            String ch = line.substring(i, i + 1);
            if (ch.equals("(") || ch.equals("[")) {
                stack.push(ch);
            } else {
                // 올바르지 못한 괄호열
                if (stack.isEmpty()) {
                    flag = true;
                    break;
                }
                if (stack.peek().equals("(") && ch.equals(")")) {
                    stack.pop();
                    stack.push("2");
                } else if (stack.peek().equals("[") && ch.equals("]")) {
                    stack.pop();
                    stack.push("3");
                } else {
                    boolean result;
                    if (ch.equals(")")) {
                        result = process("(", "[", stack);
                    } else {
                        result = process("[", "(", stack);
                    }
                    if (!result) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        if (flag || stack.isEmpty()) {
            bw.write("0\n");
        } else {
            int result = 0;
            while (!stack.isEmpty()) {
                try {
                    result += Integer.parseInt(stack.pop());
                } catch (NumberFormatException e) {
                    bw.write("0\n");
                    flag = true;
                    break;
                }
            }
            if (!flag){
                bw.write(result + "\n");
            }
        }
        bw.close();
        br.close();
    }

    private static boolean process(String pair, String stop, Stack<String> stack) {
        int result = 0;
        while (!stack.isEmpty() && !stack.peek().equals(pair)) {
            String top = stack.pop();
            if (top.equals(stop)) {
                return false;
            }
            int number = Integer.parseInt(top);
            result += number;
        }
        if (stack.isEmpty()) {
            return false;
        }
        stack.pop();
        stack.push(String.valueOf(result * (pair.equals("(") ? 2 : 3)));
        return true;
    }
}

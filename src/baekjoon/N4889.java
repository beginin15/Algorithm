package baekjoon;

import java.io.*;
import java.util.Stack;

public class N4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        int caseNum = 1;
        Stack<String> stack = new Stack<>();

        while (!(line = br.readLine()).contains("-")) {
            int length = line.length();
            for (int i = 0; i < length; i++) {
                String ch = line.substring(i, i + 1);
                if (ch.equals("{")) {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) {
                        stack.push(ch);
                    } else {
                        String top = stack.peek();
                        if (top.equals("{")) {
                            stack.pop();
                        } else {
                            stack.push(ch);
                        }
                    }
                }
            }
            int operateNum = 0;
            while (!stack.isEmpty()) {
                String right = stack.pop();
                String left = stack.pop(); // 항상 짝수개니까 empty가 아님
                if (right.equals("}") && left.equals("}")) {
                    operateNum++;
                } else if (right.equals("{") && left.equals("{")) {
                    operateNum++;
                } else if (right.equals("{") && left.equals("}")) {
                    operateNum += 2;
                }
            }
            bw.write(caseNum++ + ". " + operateNum + "\n");
            stack.clear();
        }

        bw.close();
        br.close();
    }
}

package baekjoon;

import java.io.*;
import java.util.Stack;

public class N9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        while (count-- > 0) {
            boolean flag = false;
            String line = br.readLine();
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch == '(') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) {
                        flag = true;
                        break;
                    }
                    stack.pop();
                }
            }
            if (stack.isEmpty() && flag == false) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
            stack.clear();
        }

        bw.close();
        br.close();
    }
}

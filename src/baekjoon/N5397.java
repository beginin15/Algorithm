package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        List<String> lines = new ArrayList<>();
        while (count-- > 0) {
            lines.add(br.readLine());
        }

        for (int i = 0; i < lines.size(); i++) {
            Stack<String> lStack = new Stack<>();
            Stack<String> rStack = new Stack<>();

            String line = lines.get(i);
            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                if (ch == '<') {
                    if (!lStack.isEmpty()) {
                        rStack.push(lStack.pop());
                    }
                } else if (ch == '>') {
                    if (!rStack.isEmpty()) {
                        lStack.push(rStack.pop());
                    }
                } else if (ch == '-') {
                    if (!lStack.isEmpty()) {
                        lStack.pop();
                    }
                } else {
                    lStack.push(String.valueOf(ch));
                }
            }
            while (!lStack.isEmpty()) {
                rStack.push(lStack.pop());
            }
            while (!rStack.isEmpty()) {
                bw.write(rStack.pop());
            }
            bw.write("\n");
        }

        bw.close();
        br.close();
    }
}

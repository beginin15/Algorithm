package baekjoon;

import java.io.*;
import java.util.Stack;

public class N1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String origin = br.readLine();
        int count = Integer.parseInt(br.readLine());

        Stack<String> lStack = new Stack<>();
        Stack<String> rStack = new Stack<>();

        for (int i = 0; i < origin.length(); i++) {
            lStack.push(origin.substring(i, i + 1));
        }

        while(count-- > 0) {
            String command = br.readLine();
            switch (command) {
                case "L":
                    if (!lStack.isEmpty())
                        rStack.push(lStack.pop());
                    break;
                case "D":
                    if (!rStack.isEmpty())
                        lStack.push(rStack.pop());
                    break;
                case "B":
                    if (!lStack.isEmpty())
                        lStack.pop();
                    break;
                default:
                    lStack.push(command.substring(2, 3));
                    break;
            }
        }

        while (!lStack.isEmpty()) {
            rStack.push(lStack.pop());
        }
        while (!rStack.isEmpty())
            wr.write(rStack.pop());
        wr.close();
        br.close();
    }
}

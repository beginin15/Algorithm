package baekjoon;

import java.io.*;
import java.util.LinkedList;

public class N2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = n; i > 0; i--) {
            queue.add(i);
        }

        while (queue.size() != 1) {
            queue.removeLast();

            int next = queue.removeLast();
            queue.addFirst(next);
        }

        bw.write(queue.pop() + "\n");

        bw.close();
        br.close();
    }
}

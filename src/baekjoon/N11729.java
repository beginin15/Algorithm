package baekjoon;

import java.io.*;

public class N11729 {

    private static StringBuilder sb = new StringBuilder();
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
//        bw.write((1 << n) - 1 + "\n");
        move(1, 3, n);
        bw.write(count + "\n");
        bw.write(sb.toString());

        bw.close();
        br.close();
    }

    private static void move(int from, int to, int n) throws IOException {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            count++;
            return;
        }
        move(from, 6 - from - to, n - 1);
        sb.append(from).append(" ").append(to).append("\n");
        count++;
        move(6 - from - to, to, n - 1);
    }
}

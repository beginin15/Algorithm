package baekjoon;

import java.io.*;

public class N1992 {
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        // init
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                board[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        // recursive
        StringBuilder sb = new StringBuilder();
        func(board.length, 0, 0, sb);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void func(int k, int x, int y, StringBuilder sb) {
        if (k == 1) {
            sb.append(board[y][x]);
            return;
        }
        boolean flag = false;
        int temp = board[y][x];
        loop: for (int i = y; i < y + k; i++) {
            for (int j = x; j < x + k; j++) {
                if (temp != board[i][j]) {
                    flag = true;
                    break loop;
                }
            }
        }
        if (!flag) {
            sb.append(board[y][x]);
            return;
        } else {
            sb.append("(");
            int m = k / 2;
            func(m, x, y, sb);
            func(m, x + m, y, sb);
            func(m, x, y + m, sb);
            func(m, x + m, y + m, sb);
            sb.append(")");
        }
    }
}

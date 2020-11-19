package baekjoon;

import java.io.*;

public class N2447 {
    private static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        init();

        func(n, 0, 0);

        StringBuilder sb = format();

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static void init() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void func(int k, int x, int y) {
        if (k == 1) {
            board[x][y] = '*';
            return;
        }
        int n = k / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                func(n, x + (n * i), y + (n * j));
            }
        }
    }

    private static StringBuilder format() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        return sb;
    }
}

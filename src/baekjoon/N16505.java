package baekjoon;

import java.io.*;

public class N16505 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = (int) Math.pow(2, Integer.parseInt(br.readLine()));
        char[][] board = new char[k][k];
        init(board);
        func(k, 0, 0, board);

        StringBuilder sb = format(board);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static void init(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void func(int k, int x, int y, char[][] board) {
        if (k == 1) {
            board[x][y] = '*';
            return;
        }
        int n = k / 2;
        func(n, x, y, board);
        func(n, x + n, y, board);
        func(n, x, y + n, board);
    }

    public static StringBuilder format(char[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length - i; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        return sb;
    }
}

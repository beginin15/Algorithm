package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class N1780 {
    private static int[][] board;
    private static int zero = 0;
    private static int negative = 0;
    private static int positive = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        // init
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = st.countTokens();
            for (int j = 0; j < count; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // recursive
        func(n, 0, 0);

        bw.write(negative + "\n" + zero + "\n" + positive);
        bw.close();
        br.close();
    }

    private static void func(int n, int x, int y) {
        if (n == 1) { // 기저 사례
            count(board[x][y]);
            return;
        }

        boolean flag = false;
        int temp = board[x][y];
        loop: for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (board[i][j] != temp) {
                    flag = true;
                    break loop;
                }
            }
        }
        if (!flag) {
            count(temp);
            return;
        }

        int m = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                func(m, x + (m * i), y + (m * j));
            }
        }
    }

    private static void count(int q) {
        if (q == 0) {
            zero++;
        } else if (q == 1) {
            positive++;
        } else {
            negative++;
        }
    }
}

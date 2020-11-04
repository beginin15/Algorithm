package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 열
        int n = Integer.parseInt(st.nextToken()); // 행

        int[][] board = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    queue.add(new Point(i, j));
                }
                if (board[i][j] == 0) {
                    dist[i][j] = -1;
                }
            }
        }

        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Point target = queue.remove();
            for (int i = 0; i < 4; i++) {
                int nx = dirX[i] + target.x;
                int ny = dirY[i] + target.y;
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (dist[nx][ny] >= 0) { // 이미 익거나 없는 경우에는 처리할 필요 없다.
                    continue;
                }
                dist[nx][ny] = dist[target.x][target.y] + 1;
                queue.add(new Point(nx, ny));
            }
        }

        int max = 0;
        boolean flag = false;
        loop: for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] < 0) {
                    flag = true;
                    break loop;
                }
                max = Math.max(max, dist[i][j]);
            }
        }
        if (flag) {
            bw.write("-1\n");
        } else {
            bw.write(max + "\n");
        }
        bw.close();
        br.close();
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

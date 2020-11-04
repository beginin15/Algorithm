package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        // 초기화
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                board[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        int[][] dist = new int[n][m];
        // 초기화
        // -1로 초기화하면 방문 여부까지 체크할 수 있음
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = -1;
            }
        }

        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        dist[0][0] = 0;

        while (!queue.isEmpty()) {
            Point target = queue.remove();
            for (int k = 0; k < 4; k++) {
                int nx = dirX[k] + target.x;
                int ny = dirY[k] + target.y;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (board[nx][ny] == 0 || dist[nx][ny] > 0) {
                    continue;
                }

                dist[nx][ny] = dist[target.x][target.y] + 1;
                queue.add(new Point(nx, ny));
            }
        }
        bw.write((dist[n - 1][m - 1] + 1) + "\n");
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

package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2468 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        int minH = 0;
        int maxH = 0;
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                minH = Math.min(minH, board[i][j]);
                maxH = Math.max(maxH, board[i][j]);
            }
        }

        int max = 0;
        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};

        while (minH < maxH) {
            boolean[][] visit = new boolean[n][n];
            int num = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] <= minH || visit[i][j]) {
                        continue;
                    }
                    visit[i][j] = true;
                    num++;

                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(i, j));

                    while (!queue.isEmpty()) {
                        Point target = queue.remove();
                        for (int k = 0; k < 4; k++) {
                            int nx = dirX[k] + target.x;
                            int ny = dirY[k] + target.y;

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                                continue;
                            }
                            if (board[nx][ny] <= minH || visit[nx][ny]) {
                                continue;
                            }
                            visit[nx][ny] = true;
                            queue.add(new Point(nx, ny));
                        }
                    }
                    max = Math.max(max, num);
                }
            }
            minH++;
        }
        bw.write(max + "\n");
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

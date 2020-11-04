package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        StringBuilder sb =  new StringBuilder();

        while (count-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 가로
            int n = Integer.parseInt(st.nextToken()); // 세로
            int k = Integer.parseInt(st.nextToken()); // 배추 개수

            int[][] board = new int[n][m];
            // 초기화
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[y][x] = 1;
            }

            boolean[][] visit = new boolean[n][m];
            int[] dirX = {1, 0, -1, 0};
            int[] dirY = {0, 1, 0, -1};
            int num = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 0 || visit[i][j]) {
                        continue;
                    }
                    num++;
                    visit[i][j] = true;

                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(i, j));
                    while (!queue.isEmpty()) {
                        Point target = queue.remove();
                        for (int l = 0; l < 4; l++) {
                            int nx = dirX[l] + target.x;
                            int ny = dirY[l] + target.y;

                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                                continue;
                            }
                            if (board[nx][ny] == 0 || visit[nx][ny]) {
                                continue;
                            }
                            visit[nx][ny] = true;
                            queue.add(new Point(nx, ny));
                        }
                    }
                }
            }
            sb.append(num).append("\n");
        }

        bw.write(sb.toString());
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

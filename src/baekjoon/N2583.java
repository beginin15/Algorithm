package baekjoon;

import java.io.*;
import java.util.*;

public class N2583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[m][n];

        // 1. 초기화
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            Point first = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Point second = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            fillRect(first, second, m, board);
        }

        // 2. 탐색
        boolean[][] visit = new boolean[m][n];
        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};
        int num = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] < 0 || visit[i][j]) { // 직사각형 영역이거나 이미 방문한 경우
                    continue;
                }
                num++;
                visit[i][j] = true;

                int area = 0;
                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(i, j));

                while (!queue.isEmpty()) {
                    Point target = queue.remove();
                    area++;
                    for (int l = 0; l < 4; l++) {
                        int nx = dirX[l] + target.x;
                        int ny = dirY[l] + target.y;
                        if (nx < 0 || nx >= m || ny < 0 | ny >= n) {
                            continue;
                        }
                        if (board[nx][ny] < 0 || visit[nx][ny]) { // 직사각형 영역이거나 이미 방문한 경우
                            continue;
                        }
                        visit[nx][ny] = true;
                        queue.add(new Point(nx, ny));
                    }
                }
                list.add(area);
            }
        }
        bw.write(num + "\n");
        list.sort(Integer::compareTo);
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + ((i == list.size() - 1) ? "\n" : " "));
        }
        bw.close();
        br.close();
    }

    private static void fillRect(Point first, Point second, int m, int[][] board) {
        int width = second.x - first.x;
        int height = second.y - first.y;

        Point start = new Point(first.x, first.y + (height - 1));
        int tempX = start.x;
        start.x = Math.abs(start.y - m + 1);
        start.y = tempX;

        for (int x = start.x; x < start.x + height; x++) {
            for (int y = start.y; y < start.y + width; y++) {
                board[x][y] = -1;
            }
        }
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

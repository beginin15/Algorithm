package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N4179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] board = new int[r][c];
        int[][] dist1 = new int[r][c];
        int[][] dist2 = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dist1[i][j] = dist2[i][j] = -1; // 방문 여부 체크까지 하기 위해 -1로 초기화
            }
        }

        Queue<Point> queue1 = new LinkedList<>();
        Queue<Point> queue2 = new LinkedList<>();
        // 초기화
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                String str = line.substring(j, j + 1);
                if (str.equals("F")) { // 불 시작점
                    queue1.add(new Point(i, j));
                    dist1[i][j] = 0;
                } else if (str.equals("J")) { // 지훈 시작점
                    queue2.add(new Point(i, j));
                    dist2[i][j] = 0;
                } else if (str.equals("#")) { // 벽이면 -1
                    board[i][j] = -1;
                }
            }
        }

        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};

        // 1. 불 이동 BFS
        while (!queue1.isEmpty()) {
            Point target = queue1.remove();
            for (int i = 0; i < 4; i++) {
                int nx = dirX[i] + target.x;
                int ny = dirY[i] + target.y;

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) { // 범위를 벗어난 경우 제외
                    continue;
                }
                if (board[nx][ny] < 0 || dist1[nx][ny] >= 0) { // 벽인 경우 or 이미 방문한 경우 제외
                    continue;
                }
                dist1[nx][ny] = dist1[target.x][target.y] + 1;
                queue1.add(new Point(nx, ny));
            }
        }

        // 2. 지훈 이동 BFS
        boolean flag = false;
        loop: while (!queue2.isEmpty()) {
            Point target = queue2.remove();
            for (int i = 0; i < 4; i++) {
                int nx = dirX[i] + target.x;
                int ny = dirY[i] + target.y;

                // 포인트1! 벗어난 경우가 탈출 시점. 큐 삽입은 거리순이므로 가장 먼저 벗어난 경우가 최소 탈출 시간
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    bw.write((dist2[target.x][target.y] + 1) + "\n");
                    flag = true;
                    break loop;
                }
                // 벽인 경우 or 이미 방문한 경우 제외
                if (board[nx][ny] < 0 || dist2[nx][ny] >= 0) {
                    continue;
                }
                // 포인트2! 불의 전파 시간과 비교해서 더 느린 경우 제외
                // 불 배열에서 아예 방문하지 않은 것도 제외
                if (dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[target.x][target.y] + 1) {
                    continue;
                }
                dist2[nx][ny] = dist2[target.x][target.y] + 1;
                queue2.add(new Point(nx, ny));
            }
        }
        if (!flag) {
            bw.write("IMPOSSIBLE\n");
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

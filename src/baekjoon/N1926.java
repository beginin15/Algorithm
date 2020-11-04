package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        // 도화지 초기화
        int[][] board = new int[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 방문
        boolean[][] visit = new boolean[y][x];
        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};
        int max = 0; // 최대 넓이
        int num = 0; // 그림 개수

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (board[i][j] == 0 || visit[i][j]) { // 그림이 없거나 이미 방문한 경우
                    continue;
                }
                num++;
                visit[i][j] = true; // 방문 표시

                int area = 0; // 인접한 그림 넓이
                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(j, i));

                while (!queue.isEmpty()) {
                    area++;
                    Point target = queue.remove();
                    for (int dir = 0; dir < 4; dir++) { // 인접한 4방향 검사
                        int nx = dirX[dir] + target.x;
                        int ny = dirY[dir] + target.y;
                        if (nx < 0 || nx >= x || ny < 0 || ny >= y) { // 도화지 범위를 벗어나는 경우
                            continue;
                        }
                        if (visit[ny][nx] || board[ny][nx] == 0) { // 이미 방문했거나 그림이 없으면
                            continue;
                        }
                        visit[ny][nx] = true; // 방문 표시
                        queue.add(new Point(nx, ny));
                    }
                }
                max = Math.max(max, area);
            }
        }
        bw.write(num + "\n" + max + "\n");
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

package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                String ch = line.substring(j, j + 1);
                map[i][j] = Integer.parseInt(ch);
            }
        }

        boolean[][] visit = new boolean[n][n];
        int num = 0;
        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int area = 0;
                if (map[i][j] == 0 || visit[i][j]) {
                    continue;
                }
                visit[i][j] = true; // 여기!
                num++;

                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(i, j));

                while (!queue.isEmpty()) {
                    Point target = queue.remove();
                    area++;
                    for (int k = 0; k < 4; k++) {
                        int nx = dirX[k] + target.x;
                        int ny = dirY[k] + target.y;
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                            continue;
                        }
                        if (map[nx][ny] == 0 || visit[nx][ny]) {
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
            bw.write(list.get(i) + "\n");
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

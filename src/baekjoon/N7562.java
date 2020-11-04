package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (count-- > 0) {
            // 1.
            int l = Integer.parseInt(br.readLine());
            // 2.
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point night = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            // 3.
            st = new StringTokenizer(br.readLine());
            Point dest = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            if (night.x == dest.x && night.y == dest.y) {
                sb.append("0\n");
                continue;
            }

            int[][] dist = new int[l][l];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {
                    dist[i][j] = -1;
                }
            }

            int[] dirX = {-2, -1, 1, 2, 2, 1, -1, -2};
            int[] dirY = {-1, -2, -2, -1, 1, 2, 2, 1};

            Queue<Point> queue = new LinkedList<>();
            queue.add(night);

            while (!queue.isEmpty()) {
                Point target = queue.remove();
                for (int i = 0; i < 8; i++) {
                    int nx = dirX[i] + target.x;
                    int ny = dirY[i] + target.y;

                    if (nx < 0 || nx >= l || ny < 0 || ny >= l) {
                        continue;
                    }
                    if (dist[nx][ny] >= 0) {
                        continue;
                    }
                    dist[nx][ny] = dist[target.x][target.y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
            sb.append(dist[dest.x][dest.y] + 1).append("\n");
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

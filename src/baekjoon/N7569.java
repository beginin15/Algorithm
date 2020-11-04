package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N7569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] board = new int[h][n][m];
        int[][][] dist = new int[h][n][m];
        Queue<Vertex> queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if (board[i][j][k] == 1) {
                        queue.add(new Vertex(k, j , i));
                    }
                    if (board[i][j][k] == 0) {
                        dist[i][j][k] = -1;
                    }
                }
            }
        }

        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};
        int[] dirZ = {-1, 1};

        while (!queue.isEmpty()) {
            Vertex target = queue.remove();
            for (int i = 0; i < 4; i++) {
                int nx = dirX[i] + target.x;
                int ny = dirY[i] + target.y;

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (dist[target.z][ny][nx] >= 0) { // 이미 익거나 없는 경우는 제외
                    continue;
                }
                dist[target.z][ny][nx] = dist[target.z][target.y][target.x] + 1;
                queue.add(new Vertex(nx, ny, target.z));
            }
            for (int j = 0; j < 2; j++) {
                int nz = dirZ[j] + target.z;
                if (nz < 0 || nz >= h) {
                    continue;
                }
                if (dist[nz][target.y][target.x] >= 0) {
                    continue;
                }
                dist[nz][target.y][target.x] = dist[target.z][target.y][target.x] + 1;
                queue.add(new Vertex(target.x, target.y, nz));
            }
        }

        int max = 0;
        boolean flag = false;
        loop: for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (dist[i][j][k] < 0) {
                        flag = true;
                        break loop;
                    }
                    max = Math.max(max, dist[i][j][k]);
                }
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

    private static class Vertex {
        int x;
        int y;
        int z;

        public Vertex(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}

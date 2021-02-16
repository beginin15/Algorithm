package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class N1941 {

    private static final int MAX = 25;
    private static final int LENGTH = 5;
    private static int[] dirX = {1, 0, -1, 0}; // 우측부터 반시계 방향
    private static int[] dirY = {0, 1, 0, -1};
    private static char[][] board = new char[LENGTH][LENGTH];
    private static boolean[] isUsed = new boolean[MAX];
    private static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 초기화
        for (int i = 0; i < LENGTH; i++) {
            String line = br.readLine();
            for (int j = 0; j < LENGTH; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // 2. 수열 만들기 시작
        func(0, 0);

        bw.write(total + "\n");
        bw.close();
        br.close();
    }

    private static void func(int cur, int pre) {
        if (cur == 7) {
            // 4. 선택된 수열 중 4개 이상이 S인지 검사 // 5. 선택된 수열 기준으로 인접 여부 검사 (BFS)
            if (isSOver4() && checkAdj()) {
                total++;
            }
            return;
        }
        for (int i = pre; i < MAX; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true; // 3. 백트래킹
                func(cur + 1, i);
                isUsed[i] = false; // 3. 백트래킹
            }
        }
    }

    private static boolean isSOver4() {
        int count = 0;
        for (int i = 0; i < MAX; i++) {
            if (isUsed[i]) { // 수열의 요소가 S인지 검사
                if (board[i / 5][i % 5] == 'S') {
                    count++;
                }
            }
            if (count >= 4) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkAdj() {
        // idx는 isUsed에서 선택된 7개의 요소 중 아무거나 하나 선택하면 된다.
        // 7개 중 어느 것을 선택하던 7개가 모두 인접했는지가 중요하기 때문
        int idx;
        for (idx = 0; idx < MAX; idx++) {
            if (isUsed[idx]) {
                break;
            }
        }

        // 위에서 선택된 idx를 기준으로 7개가 인접해있는지 검사
        boolean[][] visited = new boolean[LENGTH][LENGTH];
        int y = idx / 5;
        int x = idx % 5;

        visited[y][x] = true;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        int area = 1;

        while (!queue.isEmpty()) {
            Point target = queue.remove();
            for (int dir = 0; dir < 4; dir++) {
                int nx = dirX[dir] + target.x;
                int ny = dirY[dir] + target.y;

                if (nx < 0 || nx >= LENGTH || ny < 0 || ny >= LENGTH) { // 범위 검사
                    continue;
                }
                if (visited[ny][nx]) { // 이미 방문한 적 있는지 검사
                    continue;
                }
                if (!isUsed[ny * LENGTH + nx]) { // 선택된 7개 요소가 아닌 경우 제외
                    continue;
                }
                visited[ny][nx] = true; // 방문 표시
                area++; // 위 조건을 만족하고 여기까지 왔을 때 비로소 면적 증가
                queue.add(new Point(nx, ny));
            }
        }
        return area == 7;
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

package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class N15683 {
    private static int N;
    private static int M;
    private static int[][] board;
    private static List<Cam> cams = new ArrayList<>();
    private static int wall;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1. 초기화
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                board[i][j] = n;
                if (n != 0 && n != 6) {
                    boolean[] isUsed;
                    if (n == 1 || n == 3 || n == 4) {
                        isUsed = new boolean[4];
                    } else {
                        isUsed = new boolean[2];
                    }
                    cams.add(new Cam(n, new Point(j, i), isUsed));
                } else if (n == 6) {
                    wall++;
                }
            }
        }

        // 2. 백트래킹 (회전된 캠 수열 생성)
        FixedCam[] fixedCams = new FixedCam[cams.size()];
        createSeq(fixedCams,0);

        bw.write(N * M - cams.size() - wall - max + "\n");
        bw.close();
        br.close();
    }

    private static void createSeq(FixedCam[] fixedCams, int cur) {
        if (cur == cams.size()) {
            // 3. BFS (캠 수열 기반으로 촬영 가능한 영역 탐색)
            max = Math.max(max, bfs(fixedCams));
            return;
        }

        Cam cam = cams.get(cur);
        for (int i = 0; i < cam.isUsed.length; i++) {
            if (!cam.isUsed[i]) {
                fixedCams[cur] = cam.get(cam, i);
                cam.isUsed[i] = true;
                createSeq(fixedCams, cur + 1);
                cam.isUsed[i] = false;
            }
        }
    }

    private static int bfs(FixedCam[] fixedCams) {
        int cnt = 0;
        boolean[][] visited = new boolean[N][M];

        Stack<FixedCam> stack = new Stack<>();
        for (FixedCam cam: fixedCams) {
            stack.add(cam);
        }

        while (!stack.isEmpty()) {
            FixedCam cam = stack.pop();
            for (int i = 0; i < cam.dirCol.length; i++) {
                int col = cam.dirCol[i] + cam.pos.x;
                int row = cam.dirRow[i] + cam.pos.y;

                // 범위를 벗어나는 경우
                if (row < 0 || row >= N || col < 0 || col >= M) {
                    continue;
                }
                // 벽인 경우
                if (board[row][col] == 6) {
                    continue;
                }
                // 이미 방문한 경우 -> 이미 방문했더라도 그 다음으로 탐색을 이어가야 하므로 해당 조건은 적합하지 않다.
//                if (visited[row][col]) {
//                    continue;
//                }
                // 카메라가 아닌 경우
                if (!(board[row][col] >= 1 && board[row][col] <= 5)) {
                    // 이미 방문한 경우에는 탐색 영역으로 카운팅하지 않는다.
                    if (!visited[row][col]) {
                        cnt++;
                    }
                    visited[row][col] = true;
                }
                // 1. 카메라인 경우에도 탐색을 이어가야 한다.
                // 2. 이미 방문한 경우에도 그 다음으로 탐색을 이어가야 한다.
                // 3. 특정 방향으로 탐색해야 하는 카메라는 이미 스택에 담겨있고, 새로 삽입되는 영역은 한 방향으로 탐색한다.
               stack.add(new FixedCam(new Point(col, row), new int[]{cam.dirCol[i]}, new int[]{cam.dirRow[i]}));
            }
        }
        return cnt;
    }

    private static class FixedCam {
        Point pos;
        int[] dirCol;
        int[] dirRow;

        public FixedCam(Point pos, int[] dirCol, int[] dirRow) {
            this.pos = pos;
            this.dirCol = dirCol;
            this.dirRow = dirRow;
        }
    }

    private static class Cam {
        int type;
        Point pos;
        boolean[] isUsed;

        public Cam(int type, Point pos, boolean[] isUsed) {
            this.type = type;
            this.pos = pos;
            this.isUsed = isUsed;
        }

        public FixedCam get(Cam cam, int idx) {
            int[] dirCol = null;
            int[] dirRow = null;

            switch (type) {
                case 1: {
                    if (idx == 0) {
                        dirCol = new int[]{1};
                        dirRow = new int[]{0};
                    } else if (idx == 1) {
                        dirCol = new int[]{0};
                        dirRow = new int[]{-1};
                    } else if (idx == 2) {
                        dirCol = new int[]{-1};
                        dirRow = new int[]{0};
                    } else if (idx == 3) {
                        dirCol = new int[]{0};
                        dirRow = new int[]{1};
                    }
                    break;
                }
                case 2: {
                    if (idx == 0) {
                        dirCol = new int[]{1, -1};
                        dirRow = new int[]{0, 0};
                    } else if(idx == 1) {
                        dirCol = new int[]{0, 0};
                        dirRow = new int[]{-1, 1};
                    }
                    break;
                }
                case 3: {
                    if (idx == 0) {
                        dirCol = new int[]{1, 0};
                        dirRow = new int[]{0, -1};
                    } else if (idx == 1) {
                        dirCol = new int[]{0, -1};
                        dirRow = new int[]{-1, 0};
                    } else if (idx == 2) {
                        dirCol = new int[]{-1, 0};
                        dirRow = new int[]{0, 1};
                    } else if (idx == 3) {
                        dirCol = new int[]{1, 0};
                        dirRow = new int[]{0, 1};
                    }
                    break;
                }
                case 4: {
                    if (idx == 0) {
                        dirCol = new int[]{1, 0, -1};
                        dirRow = new int[]{0, -1, 0};
                    } else if (idx == 1) {
                        dirCol = new int[]{0, -1, 0};
                        dirRow = new int[]{-1, 0, 1};
                    } else if (idx == 2) {
                        dirCol = new int[]{-1, 0, 1};
                        dirRow = new int[]{0, 1, 0};
                    } else if (idx == 3) {
                        dirCol = new int[]{0, 1, 0};
                        dirRow = new int[]{-1, 0, 1};
                    }
                    break;
                }
                case 5: {
                    dirCol = new int[]{1, 0, -1, 0};
                    dirRow = new int[]{0, -1, 0, 1};
                }
            }
            return new FixedCam(cam.pos, dirCol, dirRow);
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

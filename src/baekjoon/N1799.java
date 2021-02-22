package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1799 {
    private static int size;
    private static boolean[][] canPlaced;
    private static boolean[] isUsedLT;
    private static boolean[] isUsedLB;
    private static int[] max = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        size = Integer.parseInt(br.readLine());
        canPlaced = new boolean[size][size];
        isUsedLT = new boolean[size * 2 - 1];
        isUsedLB = new boolean[size * 2 - 1];

        // 1. 초기화
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                canPlaced[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        // 2. 백트래킹
        // 체스판의 흑과 백을 나눠서 탐색한다. 흑/백은 col의 짝/홀로 구분한다.
        func(0, 0, 0, 0);
        func(0, 1, 0, 1);

        // 3. 결과 출력
        bw.write(max[0] + max[1] + "\n");
        bw.close();
        br.close();
    }

    private static void func(int row, int col, int count, int color) {
        if (row >= size) { // base condition
            if (count > max[color]) {
                max[color] = count;
            }
            return;
        }
        if (col >= size) {
            // 현재 짝수열이면 다음 행에서 홀수열로
            // 현재 홀수열이면 다음 행에서 짝수열로
            func(row + 1, col % 2 == 0 ? 1 : 0, count, color);
            return;
        }
        int lt = row + col;
        int lb = row - col + size - 1;
        if (canPlaced[row][col] && !isUsedLT[lt] && !isUsedLB[lb]) {
            isUsedLT[lt] = isUsedLB[lb] = true;
            func(row, col + 2, count + 1, color);
            isUsedLT[lt] = isUsedLB[lb] = false;
        }
        func(row, col + 2, count, color); // 비숍을 놓을 수 있어도 놓지 않고 넘어가는 경우도 고려한다? 이 부분이 어렵다.
    }
}

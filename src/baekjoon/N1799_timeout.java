package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1799_timeout {
    private static int size;
    private static boolean[][] canPlaced;
    private static boolean[] isUsedLT;
    private static boolean[] isUsedLB;
    private static int max;

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
        func(0, 0, 0);

        // 3. 결과 출력
        bw.write(max + "\n");
        bw.close();
        br.close();
    }

    private static void func(int row, int col, int count) {
        if (row >= size) { // base condition
            if (count > max) {
                max = count;
            }
            return;
        }
        if (col >= size) {
            func(row + 1, 0, count);
            return;
        }
        int lt = row + col;
        int lb = row - col + size - 1;
        if (canPlaced[row][col] && !isUsedLT[lt] && !isUsedLB[lb]) {
            isUsedLT[lt] = isUsedLB[lb] = true;
            func(row, col + 1, count + 1);
            isUsedLT[lt] = isUsedLB[lb] = false;
        }
        func(row, col + 1, count); // 비숍을 놓을 수 있어도 놓지 않고 넘어감 => ?
    }
}

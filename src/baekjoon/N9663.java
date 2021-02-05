package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N9663 {

    private static int n;
    private static int cnt;
    private static boolean[] isUsedCol;
    private static boolean[] isUsedLT;
    private static boolean[] isUsedRB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        isUsedCol = new boolean[n];
        isUsedLT = new boolean[n + n - 1];
        isUsedRB = new boolean[n + n - 1];

        func(0);

        bw.write(cnt + "\n");
        bw.close();
        br.close();
    }

    public static void func(int cur) {
        if (cur == n) {
            cnt++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int lt = cur + col;
            int rb = cur - col + n - 1;
//            System.out.println("cur: " + cur + ", col: " + col + ", lt: " + lt + ", rb: " + rb);
            if (!isUsedCol[col]
                    && !isUsedLT[lt]
                    && !isUsedRB[rb]) {
                isUsedCol[col] = isUsedLT[lt] = isUsedRB[rb] = true;
                func(cur + 1);
                isUsedCol[col] = isUsedLT[lt] = isUsedRB[rb] = false;
            }
        }
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N15650 {

    private static int n;
    private static int m;
    private static int[] arr;
    private static boolean[] isUsed;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        isUsed = new boolean[10];

        func(0, 0);

        bw.close();
        br.close();
    }

    private static void func(int k, int pre) throws IOException {
        if (k == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append("\n");
            bw.write(sb.toString());
            return;
        }
        for (int i = pre + 1; i <= n; i++) {
            if (!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                func(k + 1, i);
                isUsed[i] = false;
            }
        }
    }
}

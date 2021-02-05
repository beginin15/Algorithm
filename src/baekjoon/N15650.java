package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N15650 {

    private static int n;
    private static int m;
    private static int[] arr;
    private static boolean[] isUsed;
    private static Set<String> seq = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        isUsed = new boolean[10];

        func(0);

        for (String s : seq) {
            bw.write(s);
        }
        bw.close();
        br.close();
    }

    private static void func(int k) {
        if (k == m) {
            int[] copy = Arrays.copyOfRange(arr, 0, m);
            Arrays.sort(copy);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(copy[i]).append(' ');
            }
            sb.append("\n");
            seq.add(sb.toString());
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                func(k + 1);
                isUsed[i] = false;
            }
        }
    }
}

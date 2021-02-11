package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N15666 {

    private static int n;
    private static int m;
    private static int[] output;
    private static int[] seq;
    private static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        seq = new int[n];
        output = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(seq);
        func(0, 0);

        for (String s : set) {
            bw.write(s);
        }
        bw.close();
        br.close();
    }

    private static void func(int cur, int pre) {
        if (cur == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(output[i]).append(' ');
            }
            sb.append("\n");
            set.add(sb.toString());
            return;
        }

        for (int i = pre; i < n; i++) {
            output[cur] = seq[i];
            func(cur + 1, i);
        }
    }
}

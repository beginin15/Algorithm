package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N6603 {

    private static List<Case> cases = new ArrayList<>();
    private static final int MAX = 6;
    private static boolean[] isUsed = new boolean[13];
    private static int[] output = new int[MAX];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        init(br);
        forEach();

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            } else {
                int count = st.countTokens();
                int[] seq = new int[count];
                for (int i = 0; i < count; i++) {
                    seq[i] = Integer.parseInt(st.nextToken());
                }
                cases.add(new Case(n, seq));
            }
        }
    }

    private static void forEach() {
        for (Case c : cases) {
            func(0, 0, c);
            sb.append("\n");
        }
    }

    private static void func(int cur, int pre, Case c) {
        if (cur == MAX) {
            for (int i = 0; i < MAX; i++) {
                sb.append(output[i]).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = pre; i < c.n; i++) {
            if (!isUsed[i]) {
                output[cur] = c.seq[i];
                isUsed[i] = true;
                func(cur + 1, i, c);
                isUsed[i] = false;
            }
        }
    }

    private static class Case {
        int n;
        int[] seq;

        public Case(int n, int[] seq) {
            this.n = n;
            this.seq = seq;
        }
    }
}

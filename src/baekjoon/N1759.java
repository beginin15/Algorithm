package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1759 {

    private static int l;
    private static int c;
    private static char[] seq;
    private static char[] output;
    private static boolean[] isUsed = new boolean[15];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        output = new char[l];
        seq = new char[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            seq[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(seq);
        func(0, 0);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void func(int cur, int pre) {
        if (cur == l) {
            if (!check()) {
                return;
            }
            for (int i = 0; i < l; i++) {
                sb.append(output[i]);
            }
            sb.append("\n");
            return;
        }
        for (int i = pre; i < c; i++) {
            if (!isUsed[i]) {
                output[cur] = seq[i];
                isUsed[i] = true;
                func(cur + 1, i);
                isUsed[i] = false;
            }
        }
    }

    private static boolean check() {
        int vowel = 0;
        int consonants = 0;
        for (int i = 0; i < l; i++) {
            char ch = output[i];
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowel++;
            } else {
                consonants++;
            }
        }
        return vowel >= 1 && consonants >= 2;
    }
}

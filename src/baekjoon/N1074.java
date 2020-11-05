package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class N1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bw.write(move(n, r, c) + "\n");

        bw.close();
        br.close();
    }

    private static int move(int n, int r, int c) {
        if (n == 0) {
             return 0;
        }
        int half = 1 << (n - 1);
        if (r < half && c < half) {     // 첫 번째 사각형
            return move(n - 1, r, c);
        }
        if (r < half && c >= half) {    // 두 번째 사각형
            return half * half + move(n - 1, r, c - half); // 첫 번째 넓이에 더하기
        }
        if (r >= half && c < half) {    // 세 번째 사각형
            return 2 * half * half + move(n - 1, r - half, c);
        }
        return 3 * half * half + move(n - 1, r - half, c - half); // 네 번째 사각형
    }
}

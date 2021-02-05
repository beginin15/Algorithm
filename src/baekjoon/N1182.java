package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1182 {
    private static int n;
    private static int s;
    private static int[] arr;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 공집합 제외
        func(0, 0);
        if (s == 0) cnt--;

        bw.write(cnt + "\n");
        bw.close();
        br.close();
    }

    private static void func(int cur, int sum) {
        if (cur == n) {
            if (sum == s) cnt++;
            return;
        }
        // 수열에 추가하지 않은 경우
        func(cur + 1, sum);
        // 수열에 추가한 경우
        func(cur + 1, sum + arr[cur]);
    }
}

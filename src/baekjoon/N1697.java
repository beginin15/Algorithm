package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dist = new int[200000];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = -1;
        }

        dist[n] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n);

        while (dist[k] == -1) {
            int target = queue.remove();
            int[] arr = {target - 1, target + 1, target * 2};
            for (int i = 0; i < arr.length; i++) {
                int number = arr[i];
                if (number < 0 || number >= 200000) {
                    continue;
                }
                if (dist[number] >= 0) {
                    continue;
                }
                dist[number] = dist[target] + 1;
                queue.add(number);
            }
        }

        bw.write(dist[k] + "\n");
        bw.close();
        br.close();
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N16987 {

    private static int n;
    private static Egg[] eggs;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        eggs = new Egg[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), false);
        }

        func(0);

        bw.write(max + "\n");
        bw.close();
        br.close();
    }

    private static void func(int cur) {
        if (n == cur) {
            count(cur);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (cur == i) {
                continue;
            }
            if (eggs[cur].isCrashed) { // 손 계란 깨짐
                func(cur + 1);
                continue;
            }
            if (!eggs[cur].isCrashed && eggs[i].isCrashed) { // 손 계란 안깨짐, 다른 계란 깨짐
                continue;
            }
            // 둘 다 안깨
            eggs[cur].crash(eggs[i]); eggs[i].crash(eggs[cur]);
            func(cur + 1);
            eggs[cur].restore(eggs[i]); eggs[i].restore(eggs[cur]);
        }
        count(cur);
    }

    private static void count(int cur) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (eggs[i].isCrashed) {
                count++;
            }
        }
        if (count > max) {
            max = count;
        }
    }

    private static class Egg {
        int durability;
        int weight;
        boolean isCrashed;

        public Egg(int durability, int weight, boolean isCrashed) {
            this.durability = durability;
            this.weight = weight;
            this.isCrashed = isCrashed;
        }

        void crash(Egg other) {
            this.durability -= other.weight;
            if (this.durability <= 0) {
                this.isCrashed = true;
            }
        }

        void restore(Egg other) {
            this.durability += other.weight;
            this.isCrashed = false;
        }
    }
}

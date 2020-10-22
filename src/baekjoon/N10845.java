package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class N10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        MyQueue queue = new MyQueue();

        while (count-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push" :
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    bw.write(queue.pop() + "\n");
                    break;
                case "size" :
                    bw.write(queue.size() + "\n");
                    break;
                case "empty" :
                    bw.write(queue.empty() + "\n");
                    break;
                case "front" :
                    bw.write(queue.front() + "\n");
                    break;
                case "back" :
                    bw.write(queue.back() + "\n");
                    break;
            }
        }

        bw.close();
        br.close();
    }

    private static class MyQueue {
        private static final int MAX = 10_000;
        private int[] data;
        private int size;
        private int head;
        private int tail;

        public MyQueue() {
            this.data = new int[MAX];
            this.head = this.tail = this.size = 0;
        }

        void push(int x) {
            if (size >= MAX) {
                return;
            }
            data[tail++] = x;
            size++;
        }

        int pop() {
            if (size == 0) {
                return -1;
            }
            size--;
            return data[head++];
        }

        int size() {
            return size;
        }

        int empty() {
            return size == 0 ? 1 : 0;
        }

        int front() {
            if (size <= 0) {
                return -1;
            }
            return data[head];
        }

        int back() {
            if (size <= 0) {
                return -1;
            }
            return data[tail - 1];
        }
    }
}

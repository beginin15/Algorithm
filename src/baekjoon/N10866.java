package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class N10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        MyDeque deque = new MyDeque();
        StringBuilder sb = new StringBuilder();

        while (count-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front":
                    deque.pushFront(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.pushBack(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(deque.popFront() + "\n");
                    break;
                case "pop_back":
                    sb.append(deque.popBack() + "\n");
                    break;
                case "size":
                    sb.append(deque.size() + "\n");
                    break;
                case "empty":
                    sb.append(deque.empty() + "\n");
                    break;
                case "front":
                    sb.append(deque.front() + "\n");
                    break;
                case "back":
                    sb.append(deque.back() + "\n");
                    break;
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static class MyDeque {
        private static final int MAX = 10_000;
        private int[] deque;
        private int head;
        private int tail;
        private int size;

        public MyDeque() {
            this.deque = new int[MAX * 2 + 1];
            this.head = MAX;
            this.tail = MAX;
            this.size = 0;
        }

        void pushFront(int x) {
            deque[--head] = x;
            size++;
        }

        void pushBack(int x) {
            deque[tail++] = x;
            size++;
        }

        int popFront() {
            if (size == 0) {
                return -1;
            }
            size--;
            return deque[head++];
        }

        int popBack() {
            if (size == 0) {
                return -1;
            }
            size--;
            return deque[--tail];
        }

        int size() {
            return size;
        }

        int empty() {
            return size == 0 ? 1 : 0;
        }

        int front() {
            if (size == 0) {
                return -1;
            }
            return deque[head];
        }

        int back() {
            if (size == 0) {
                return -1;
            }
            return deque[tail - 1];
        }
    }
}

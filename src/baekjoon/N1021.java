package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class N1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st1.nextToken());
        int count = Integer.parseInt(st1.nextToken());

        MyDeque deque = new MyDeque(n);
        for (int i = 0; i < n; i++) {
            deque.add(i + 1);
        }

        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
            if (arr[i] > n) {
                bw.write("0\n");
                bw.close();
                br.close();
                return;
            }
        }

        int i = 0;
        int result = 0;
        while (count-- > 0) {
//            System.out.println("=============");
//            System.out.println("deque.size: " + deque.size);
//            System.out.println("count: " + count);
//            System.out.println("arr[i]: " + arr[i]);
            if (arr[i] == deque.getFirst()) {
                deque.removeFirst();
                i++;
                continue;
            }
            int index = deque.indexOf(arr[i]);
//            System.out.println("index: " + index);
            int front = index;
            int back = deque.size - index;
//            System.out.println("front: " + front);
//            System.out.println("back: " + back);
            if (front < back) {
                for (int j = 0; j < front; j++) {
//                    deque.print();
                    deque.addLast(deque.removeFirst());
                    result++;
                }
                deque.removeFirst();
//                result += front;
            } else {
                for (int j = 0; j < back; j++) {
//                    deque.print();
                    deque.addFirst(deque.removeLast());
                    result++;
                }
                deque.removeFirst();
//                result += back;
            }
            i++;
//            System.out.println("result: " + result);
        }
        bw.write(result + "\n");
        bw.close();
        br.close();
    }

    private static class MyDeque {
        private final int[] deque;
        private final int max;
        private int head;
        private int tail;
        private int size;

        public MyDeque(int size) {
            this.max = size;
            this.deque = new int[size];
            this.head = this.tail = 0;
        }

        void add(int x) {
            addLast(x);
        }

        void addFirst(int x) {
            if (head - 1 < 0) {
                head = max - 1;
            } else {
                head -= 1;
            }
            size++;
            deque[head] = x;
        }

        void addLast(int x) {
            deque[tail++] = x;
            if (tail >= max) {
                tail = 0;
            }
            size++;
        }

        int removeFirst() {
            int x = deque[head++];
            if (head >= max) {
                head = 0;
            }
            size--;
            return x;
        }

        int removeLast() {
            if (tail - 1 < 0) {
                tail = max - 1;
            } else {
                tail -= 1;
            }
            size--;
            return deque[tail];
        }

        int getFirst() {
            return deque[head];
        }

        int getLast() {
            if (tail - 1 < 0) {
                return deque[max - 1];
            }
            return deque[tail - 1];
        }

//        void print() {
//            for (int i = head; i < head + size; i++) {
//                System.out.printf("%d ", deque[i % max]);
//            }
//            System.out.println();
//        }

        int indexOf(int x) {
            int index = 0;
            int i = head;
            while (deque[i] != x) {
                i++;
                index++;
                if (i >= max) {
                    i = 0;
                }
            }
            return index;
        }
    }
}

package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class N10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        MyStack stack = new MyStack();

        while (count-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push" :
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    bw.write(stack.pop() + "\n");
                    break;
                case "top" :
                    bw.write(stack.top() + "\n");
                    break;
                case "size" :
                    bw.write(stack.size() + "\n");
                    break;
                case "empty" :
                    bw.write((stack.isEmpty() ? 1 : 0) + "\n");
                    break;
            }
        }

        bw.close();
        br.close();
    }

    static class MyStack {
        static final int MAX = 10_000;
        private int[] data;
        private int pos = 0;

        public MyStack() {
            data = new int[MAX];
        }

        void push(int x) {
            data[pos++] = x;
        }

        int pop() {
            return isEmpty() ? -1 : data[--pos];
        }

        int top() {
           return isEmpty() ? -1 : data[pos - 1];
        }

        int size() {
            return pos;
        }

        boolean isEmpty() {
            return pos == 0;
        }
    }
}

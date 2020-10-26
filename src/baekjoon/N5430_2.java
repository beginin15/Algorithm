package baekjoon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class N5430_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        while (count-- > 0) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String value = br.readLine();
            Deque<Integer> deque = new LinkedList<>();

            String[] arr = value.substring(1, value.length() - 1).split(",");
            if (arr.length <= 1) {
                bw.write("error\n");
                continue;
            }
            for (int i = 0; i < arr.length; i++) {
                deque.add(Integer.parseInt(arr[i]));
            }
            boolean isFront = true, isError = false;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < command.length(); i++) {
                switch (command.charAt(i)) {
                    case 'R':
                        isFront = !isFront;
                        break;
                    case 'D':
                        if (deque.isEmpty()) {
                            if (i != command.length() - 1) {
                                isError = true;
                                break;
                            }
                        } else {
                            if (isFront) {
                                deque.removeFirst();
                            } else {
                                deque.removeLast();
                            }
                        }
                        break;
                }
            }

            if (isError) {
                sb.append("error");
            } else if (deque.isEmpty()){
                sb.append("[]");
            } else {
                int size = deque.size();
                sb.append("[");
                if (isFront) {
                    for (int i = 0; i < size; i++) {
                        sb.append(deque.removeFirst()).append(",");
                    }
                } else {
                    for (int i = 0; i < size; i++) {
                        sb.append(deque.removeLast()).append(",");
                    }
                }
                sb.deleteCharAt(sb.length() - 1).append("]");
            }
            bw.write(sb.toString() + "\n");
        }
        bw.close();
        br.close();
    }
}

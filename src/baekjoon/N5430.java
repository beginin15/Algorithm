package baekjoon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class N5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().replace("[", "").replace("]", "").split(",");
            String result = ac(command, n, arr);
            bw.write(result + "\n");
        }
        bw.close();
        br.close();
    }

    private static String ac(String command, int n, String[] arr) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            deque.add(Integer.parseInt(arr[i]));
        }
        boolean isFront = true;
        for (int i = 0; i < command.length(); i++) {
            switch (command.charAt(i)) {
                case 'R':
                    isFront = !isFront;
                    break;
                case 'D':
                    if (deque.isEmpty()) {
                        return "error";
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
        StringBuilder sb = print(deque, isFront);
        return sb.toString();
    }

    private static StringBuilder print(Deque<Integer> deque, boolean isFront) {
        int size = deque.size();
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (isFront) {
                sb.append(deque.removeFirst());
            } else {
                sb.append(deque.removeLast());
            }
            if (!deque.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb;
    }
}

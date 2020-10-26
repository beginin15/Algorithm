package baekjoon;

import java.io.*;

public class N5430_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        while (count-- > 0) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String value = br.readLine();

            String[] arr = value.substring(1, value.length() - 1).split(",");
            int start = 0;
            int end = arr.length - 1;
            boolean isFront = true, isError = false;

            if (arr.length <= 1) {
                bw.write("error\n");
                continue;
            }

            loop: for (int i = 0; i < command.length(); i++) {
                switch (command.charAt(i)) {
                    case 'R':
                        isFront = !isFront;
                        break;
                    case 'D':
                        if (isFront) {
                            ++start;
                        } else {
                            --end;
                        }
                        if (start > end && i != command.length() - 1) {
                            isError = true;
                            break loop;
                        }
                        break;
                }
            }
            if (isError) {
                bw.write("error\n");
                continue;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if (isFront) {
                for (int i = start; i <= end; i++) {
                    sb.append(arr[i] + ",");
                }
            } else {
                for (int i = end; i >= start; i--) {
                    sb.append(arr[i] + ",");
                }
            }
            if (sb.length() != 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append("]\n");
            bw.write(sb.toString());
        }

        bw.close();
        br.close();
    }
}

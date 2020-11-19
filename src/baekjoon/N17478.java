package baekjoon;

import java.io.*;

public class N17478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");

        func(n, 0, sb);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static void func(int n, int i, StringBuilder sb) {
        StringBuilder underline = new StringBuilder();
        for (int j = 0; j < i * 4; j++) {
            underline.append("_");
        }
        sb.append(underline).append("\"재귀함수가 뭔가요?\"\n");

        if (n == 0) { // base condition
            sb.append(underline).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n")
                    .append(underline).append("라고 답변하였지.\n");
            return;
        }

        sb.append(underline).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n")
                .append(underline).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n")
                .append(underline).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
        func(n - 1, i + 1, sb);
        sb.append(underline).append("라고 답변하였지.\n");
    }
}

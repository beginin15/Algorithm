package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class N1941 {

    private static final int LENGTH = 5;
    private static Student[][] arr = new Student[LENGTH][LENGTH];
    private static boolean[][] isUsed = new boolean[LENGTH][LENGTH];
    private static Student[] output = new Student[7];
    private static Set<Students> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < LENGTH; i++) {
            String line = br.readLine();
            for (int j = 0; j < LENGTH; j++) {
                arr[i][j] = new Student(line.charAt(j));
            }
        }
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                isUsed = new boolean[LENGTH][LENGTH];
                func(0, i, j);
            }
        }
        bw.write(set.size() + "\n");
        bw.close();
        br.close();
    }

    private static void func(int k, int row, int column) {
        if (k == 7) {
            int countS = 0;
            for (int i = 0; i < 7; i++) {
                if (output[i].ch == 'S') {
                    countS++;
                }
            }
            if (countS >= 4) {
                set.add(new Students(output.clone()));
            }
            return;
        }
        if (!isUsed[row][column]) {
            output[k] = arr[row][column];
            isUsed[row][column] = true;
            int top = row - 1;
            if (top >= 0 && top < 5) {
                func(k + 1, top, column);
            }
            // 하
            int down = row + 1;
            if (down >= 0 && down < 5) {
                func(k + 1, down, column);
            }
            // 좌
            int left = column - 1;
            if (left >= 0 && left < 5) {
                func(k + 1, row, left);
            }
            // 우
            int right = column + 1;
            if (right >= 0 && right < 5) {
                func(k + 1, row, right);
            }
            isUsed[row][column] = false;
        }
    }

    private static class Student {
        char ch;

        public Student(char ch) {
            this.ch = ch;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new Student(ch);
        }
    }

    private static class Students {
        Student[] students;

        public Students(Student[] students) {
            this.students = students;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Students)) return false;
            Students students1 = (Students) o;
            return Arrays.equals(students, students1.students);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(students);
        }
    }
}

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];

        for(int i = 0; i < commands.length; ++i){
            answer[i] = getNumber(array, commands[i]);
        }
        return answer;
    }

    private int getNumber(int[] array, int[] command){
        int[] partition = getPartition(array, command[0], command[1]);
        Arrays.sort(partition);
        return partition[command[2] - 1];
    }

    private int[] getPartition(int[] array, int start, int end){
        return Arrays.copyOfRange(array, start - 1, end);
    }

    public static void main(String[] args) {
        new Solution().solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
    }
}
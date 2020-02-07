import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];

        for(int i = 0; i < commands.length; ++i){
            answer[i] = getNumber(array, commands[i]);
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    private int getNumber(int[] array, int[] command){
        int[] partition = getPartition(array, command[0], command[1]);
//        Arrays.sort(partition);
        sort(partition, 0, partition.length - 1);
        return partition[command[2] - 1];
    }

    private int[] getPartition(int[] array, int start, int end){
        return Arrays.copyOfRange(array, start - 1, end);
    }

    private void sort(int[] arr, int start, int end){
        int pivot = arr[(start + end) / 2];
        int pointLeft = start;
        int pointRight = end;

        if(start == end)
            return;

        while(start <= end){
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;
            if(start <= end){
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        if(pointLeft < end)
            sort(arr, pointLeft, end);

        if(pointRight > start)
            sort(arr, start, pointRight);
    }

    private void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args) {
        new Solution().solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
    }
}
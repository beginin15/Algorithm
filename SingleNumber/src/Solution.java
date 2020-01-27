import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();

        for(int number : nums) {
            if(!hashSet.remove(number))
                hashSet.add(number);
        }

        return hashSet.iterator().next();
    }

    public static void main(String[] args) {
        new Solution().singleNumber(new int[] {4, 1, 2, 1, 2});
    }
}

package leetcode;

import java.util.HashSet;
import java.util.Set;

public class N136 {
    public int singleNumber(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();

        for(int number : nums) {
            if(!hashSet.remove(number))
                hashSet.add(number);
        }

        return hashSet.iterator().next();
    }

    public static void main(String[] args) {
        new N136().singleNumber(new int[] {4, 1, 2, 1, 2});
    }
}

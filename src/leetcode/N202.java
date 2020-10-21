package leetcode;

import java.util.HashSet;

public class N202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        int sum = 0;
        String number = null;

        while (sum != 1) {
            sum = 0;
            number = Integer.toString(n);
            for (int index = 0; index < number.length(); ++index) {
                sum += Math.pow(number.charAt(index) - '0', 2);
            }
            n = sum;

            if (set.contains(n))
                return false;
            set.add(n);
        }

        return true;
    }
}

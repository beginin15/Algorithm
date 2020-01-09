public class Solution {
    public int reverse(int x) {
        long numberX = (x >= 0) ? x : ((long)(x) * -1);
        StringBuilder conversion = new StringBuilder(String.valueOf(numberX));
        conversion.reverse();
        long value = Long.parseLong(conversion.toString());
        if(Integer.MIN_VALUE < value && value < Integer.MAX_VALUE) {
            int intValue = (int) value;
            return x > 0 ? intValue : intValue * -1;
        }
        else
            return 0;
    }
}

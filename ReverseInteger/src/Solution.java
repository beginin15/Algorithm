public class Solution {
    public int reverse(int x) {
        int answer = 0;
        String numberX = String.valueOf(x);
        StringBuilder conversion = new StringBuilder(numberX.length());

        if(x < 0){
            conversion.append("-");
        }

        for(int index = numberX.length() - 1; index >= (x >= 0 ? 0 : 1); --index){
            conversion.append(numberX.charAt(index));
        }

        try{
            answer = Integer.parseInt(conversion.toString());
        } catch (NumberFormatException e){
            answer = 0;
        }

        return answer;
    }
}

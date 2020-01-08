import java.util.HashMap;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int index = 0; index < participant.length; ++index){
            String name = participant[index];
            if(hashMap.containsKey(name)){
                int count = hashMap.get(name);
                hashMap.replace(participant[index], ++count);
            } else{
                hashMap.put(name, 1);
            }
        }

        for(int index = 0; index < completion.length; ++index){
            String name = completion[index];
            int count = hashMap.get(name) - 1;
            if(count == 0)
                hashMap.remove(name);
            else
                hashMap.replace(name, count);
        }

        return hashMap.keySet().iterator().next();
    }
}

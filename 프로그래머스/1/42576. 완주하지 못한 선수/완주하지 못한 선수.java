import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> hashMap = new HashMap<>(); 
        
        for(String c : completion) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        
        for(String p : participant) {
            if(!hashMap.containsKey(p)) {
                answer = p;
            } else if(hashMap.get(p) == 0){
                answer = p;
            } else {
                hashMap.put(p, hashMap.get(p) - 1);
            }
        }
        
        return answer;
    }
}
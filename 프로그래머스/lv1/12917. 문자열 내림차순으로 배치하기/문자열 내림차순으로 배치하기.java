import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        List<String> arr = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++) {
            arr.add(String.valueOf(s.charAt(i)));
        }
        
        Collections.sort(arr);
        
        for(int i = 0; i < arr.size(); i++) {
            answer += arr.get(arr.size()-i-1);
        }
        
        return answer;
    }
}
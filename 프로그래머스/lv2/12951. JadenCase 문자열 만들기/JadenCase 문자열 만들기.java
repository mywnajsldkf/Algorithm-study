import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] s_array = s.split(" ");
        
        for(int i = 0; i < s_array.length; i++) {
            String now = s_array[i];
            
            if(now.length() == 0) {
                answer += " ";
            }
            // 문자가 있다면
            else {
                answer += now.substring(0,1).toUpperCase();
                answer += now.substring(1, now.length()).toLowerCase();
                answer += " ";
            }
        }
        
        if (s.substring(s.length()-1, s.length()).equals(" ")) {
            return answer;
        }
        
        return answer.substring(0, answer.length()-1);
    }
    
}
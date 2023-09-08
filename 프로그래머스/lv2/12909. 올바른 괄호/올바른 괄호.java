import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>(); 
        
        for(int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if(now == '(') {
                stack.add(now);
            } else if(now == ')') {
                if(stack.isEmpty()) {
                    answer = false;
                    return answer;
                }
                stack.pop();
            }
        }
        
        if(stack.size() != 0) {
            answer = false;
        }
        
        return answer;
    }
}
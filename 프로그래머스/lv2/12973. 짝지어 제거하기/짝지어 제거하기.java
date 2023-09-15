import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        char[] charArray = s.toCharArray();
        
        Stack<Character> stack = new Stack<>();
        
        for(char ch : charArray) {
            if(!stack.isEmpty()){
                if(stack.peek() == ch) {
                    stack.pop();
                } else {
                    stack.add(ch);
                }                
            } else {
                stack.add(ch);
            }
        }
        
        if(stack.isEmpty()) {
            answer = 1;
        } else {
            answer = 0;
        }

        return answer;
    }
}
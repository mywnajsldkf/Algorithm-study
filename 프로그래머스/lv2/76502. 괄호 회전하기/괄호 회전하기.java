import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack;
        
        for(int start = 0; start < s.length(); start++) {  // 회전시킨다.
            stack = new Stack<>();
            // [, (, { -> stack에 넣는다. ], ), } -> stack에서 꺼낸다.
            for(int i = 0; i < s.length(); i++) {
                Character c = s.charAt((i + start) % s.length());
                if(stack.isEmpty()) {   // stack이 비어있으면 -> stack에 넣는다.
                    stack.push(c);
                } else {
                    char pc = stack.peek();
                    // System.out.println("c: " + c + " pc: " + pc);
                    if(pc == '(' && c == ')') {
                        stack.pop();
                    } else if(pc == '[' && c == ']') {
                        stack.pop();
                    } else if(pc == '{' && c == '}') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }   
            if(stack.isEmpty()) {
                answer += 1;
            }
        }
        
        return answer;
    }
}
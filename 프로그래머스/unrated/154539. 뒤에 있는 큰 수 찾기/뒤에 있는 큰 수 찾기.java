import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int size = numbers.length;
        int[] answer = new int[size];
        
        Stack<Integer> stack = new Stack<>();
        
        stack.push(0);  // 첫번째 인덱스 설정
        
        for(int i = 1; i < size; i++) {
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                answer[stack.pop()] = numbers[i];  
            }
            
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}
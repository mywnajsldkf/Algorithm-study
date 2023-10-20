import java.util.*;

class Solution {
    static Stack<int[]> stack;
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        stack = new Stack<>();
        
        boolean isGrowing = true;
        int before = prices[0];
        
        stack.add(new int[]{before, 0}); // value와 넣는 시간
        
        for(int i = 1; i < prices.length; i++) {
            int cur = prices[i];
            if(cur < before) {  // 더 작은 값을 만났다.
                while(!stack.isEmpty()) {
                    int[] stock = stack.peek();
                    if(stock[0] > cur) {
                        answer[stock[1]] = i - stock[1];
                        stack.pop();
                    } else break;
                }
            } 
            stack.add(new int[]{cur, i});
            before = cur;
        }
        
        while(!stack.isEmpty()) {
            int[] stock = stack.pop();
            answer[stock[1]] = prices.length - stock[1] - 1;
        }
        
        return answer;
    }
}
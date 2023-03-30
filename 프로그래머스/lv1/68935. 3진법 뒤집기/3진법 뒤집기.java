import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = n;
        List<Integer> numbers = new ArrayList<>();
        
        while(answer >= 3){
            numbers.add(answer % 3);
            answer /= 3;
        }
        numbers.add(answer);
        
        answer = 0;
        
        // 3, 2, 1
        for(int i = numbers.size() -1; i >= 0; i--){
            answer += numbers.get(i) * Math.pow(3,(numbers.size()-1-i));
            
        }
        
        return answer;
    }
}
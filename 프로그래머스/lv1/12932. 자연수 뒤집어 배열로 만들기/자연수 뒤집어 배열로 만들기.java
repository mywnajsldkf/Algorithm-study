import java.util.*;

class Solution {
    public int[] solution(long n) {
        List<Long> temp = new ArrayList<>();
        
        while(n > 0) {
            temp.add(n % 10);
            n /= 10;
        }
        
        int[] answer = new int[temp.size()];
        
        for(int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i).intValue();
        }
        
        return answer;
    }
}
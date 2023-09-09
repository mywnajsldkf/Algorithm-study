import java.util.*;

class Solution {
    public long solution(long n) {
        String answer = "";
        List<Long> arr = new ArrayList<>();
        
        while(n != 0) {
            arr.add(n%10);
            n /= 10;
        }
        
        Collections.sort(arr);
        
        int arrSize = arr.size();
        for(int i = 0; i < arrSize; i++) {
            answer += String.valueOf(arr.get(arrSize - 1 - i));
        }
        
        return Long.parseLong(answer);
    }
}
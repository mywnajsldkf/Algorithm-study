import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        // long min = (long) times[0] * n;
        long min = 1;        
        long max = (long) times[times.length - 1] * n;
        answer = max;
        
        while(min <= max) {
            long average = (min + max) / 2;
            long tmp_n = 0;
            
            for(int i = 0; i < times.length; i++) {
                tmp_n += average / times[i];
                if(tmp_n > n) break;
            }
            
            if(tmp_n < n) min = average + 1;
            else {
                answer = Math.min(answer, average);
                max = average - 1;
            }
        }
        
        return answer;
    }
}
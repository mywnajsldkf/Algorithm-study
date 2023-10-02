import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        int idx = 0;
        for(long i = left; i <= right; i++) {
            long y = i / n;
            long x = i % n;
            answer[idx] = Math.max((int)y, (int)x) + 1;
            idx++;
        }
        
        return answer;
    }
}
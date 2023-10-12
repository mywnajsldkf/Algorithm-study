import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int w : works) {
            queue.add(w);
        }
        
        while(n > 0) {
            int put = queue.poll() - 1;
            if(put >= 0) {
                queue.add(put);
            }
            if(put < 0) {
                queue.add(0);
            }
            n--;
        }
        
        while(!queue.isEmpty()) {
            answer += Math.pow(queue.poll(), 2);
        }
        
        return answer;
    }
}
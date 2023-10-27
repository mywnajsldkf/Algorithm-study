import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        
        for(int s : scoville) {
            queue.add(s);
        }
        
        while(true) {
            if(queue.size() == 1) {
                if(queue.peek() < K) {
                    answer = -1;
                    break;
                }
            }
            if(queue.peek() >= K) break;
            
            int first = queue.poll();
            int second = queue.poll();
            queue.add(first + second * 2);
            answer++;
        }
        
        return answer;
    }
}
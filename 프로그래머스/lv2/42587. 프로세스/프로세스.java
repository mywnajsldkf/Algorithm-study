import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int p : priorities) {
            pq.add(p);
        }
        
        while(!pq.isEmpty()) {
            for(int i = 0; i < priorities.length; i++) {
                if(priorities[i] == pq.peek()) {
                    pq.poll();  // 일치하는 것이 있으면 poll()을 통해 제거해주고, answer를 증가한다.
                    answer++;
                    if(i == location) {
                        return answer;  // 원하는 위치의 원소를 찾으면 return한다.
                    }
                }
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> queue = new LinkedList<>();
        int answer = 0;
        
        if(cacheSize == 0) {
            answer = cities.length * 5;
            return answer;
        }
        
        for(String city : cities) {
            String name = city.toLowerCase();
            if(queue.contains(name)) {
                answer += 1;
                queue.remove(name);
                queue.add(name);
            }
            else if(queue.size() < cacheSize) {
                answer += 5;
                queue.add(name);
            } else {
                queue.poll();
                answer += 5;                
                queue.add(name);
            }
        }
        
        return answer;
    }
}
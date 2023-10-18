import java.util.*;

class Solution {
    static boolean[] visited;
    static PriorityQueue<String> queue;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        queue = new PriorityQueue<String>();
        
        visited = new boolean[tickets.length];
        
        dfs("ICN", 0, "ICN", tickets);
        
        String stringAnswer = queue.poll();
        answer = stringAnswer.split(",");
        
        return answer;
    }

    static void dfs(String now, int count, String trip, String[][] tickets) {
        if(count == tickets.length) {
            queue.add(trip);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && now.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets[i][1], count+1, trip + "," + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}
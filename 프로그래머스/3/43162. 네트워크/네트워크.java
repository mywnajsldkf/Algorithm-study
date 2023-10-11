import java.util.*;

class Solution {
    static boolean[] computer;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        computer = new boolean[computers.length];
        
        for(int i = 0; i < computers.length; i++) {
            if(computer[i]) {
                continue;
            } else {
                // System.out.println(computer[i]);
                answer += 1;
                bfs(i, computers);
            }
        }
        
        return answer;
    }
    
    static void bfs(int j, int[][] c) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(j);
        computer[j] = true;
        
        while(!queue.isEmpty()) {
            int n = queue.poll();
            for(int i = 0; i < c.length; i++) {
                if(c[n][i] == 1 && !computer[i]) {
                    queue.add(i);
                    computer[i] = true;
                }
            }
        }
    }
}
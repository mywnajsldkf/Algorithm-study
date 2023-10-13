import java.util.*;

class Solution {
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int y_size, x_size;
    static int answer;
    public int solution(int[][] maps) {
        answer = 0;
        y_size = maps.length;
        x_size = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{0, 0});
        maps[0][0] = 2;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int now_y = now[0];
            int now_x = now[1];
            
            if(now_y == y_size - 1 && now_x == x_size - 1) {
                answer = maps[now_y][now_x] - 1;
                break;
            }
            
            for(int i = 0; i < 4; i++) {
                int next_y = now_y + dy[i];
                int next_x = now_x + dx[i];
                
                if(next_y < 0 || 
                   next_y >= y_size || 
                   next_x < 0 || 
                   next_x >= x_size) continue;
                
               if(maps[next_y][next_x] == 1) {
                    queue.add(new int[]{next_y, next_x});
                    maps[next_y][next_x] = maps[now_y][now_x] + 1;
               }
            }
        }
        
        if(answer == 0) answer = -1;
        
        return answer;
    }
}
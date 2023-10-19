import java.util.*;

class Solution {
    static int[][] map;
    // static boolean[][] visited;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    public int solution(int[][] rectangle, 
                        int characterX, int characterY, 
                        int itemX, int itemY) {
        int answer = 0;
        
        map = new int[102][102];
        // visited = new boolean[102][102];
        
        for(int[] r : rectangle) {
            int lx = r[0] * 2;  // 1
            int ly = r[1] * 2;  // 1
            int rx = r[2] * 2;  // 5
            int ry = r[3] * 2;  // 7
            
            // 테두리 색칠하기 -> 1
            for(int y = ly; y <= ry; y++) {
                if(map[y][lx] != 2) {
                    map[y][lx] = 1;
                }
                
                if(map[y][rx] != 2) {
                    map[y][rx] = 1;   
                }
            }
            
            for(int x = lx; x <= rx; x++) {
                if(map[ly][x] != 2) {
                    map[ly][x] = 1;
                }
                if(map[ry][x] != 2) {
                    map[ry][x] = 1;
                }
            }
            
            // 속에 있는 것 칠하기 -> 2
            for(int y = ly + 1; y <= ry-1; y++) {
                for(int x = lx + 1; x <= rx-1; x++) {
                    map[y][x] = 2;
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        int[] point = new int[]{characterY*2, characterX*2, 0};
        queue.add(point);
        map[characterY*2][characterX*2] = 3;    // 방문 표시
        // vi
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            int cy = cur[0];
            int cx = cur[1];
            
            if(cy == itemY*2 && cx == itemX*2) {
                answer = cur[2] / 2;
                break;
            }
            
            
            for(int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                
                if(map[ny][nx] == 1) {
                    int[] nextPoint = new int[]{ny, nx, cur[2]+1};
                    map[ny][nx] = 3;
                    queue.add(nextPoint);
                }
            }
        }
        return answer;
    }
}
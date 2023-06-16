import java.util.*;

class Solution {
    static int[] move = new int[2];
    static int[][] map;
    static int height, width;
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer= {};
        height = park.length;
        width = park[0].length();
        
        // System.out.println(height);
        // System.out.println(width);
        
        map = new int[height][width];
        
        // map 초기화
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(park[i].charAt(j) == 'S') {
                    move[0] = i;
                    move[1] = j;
                    map[i][j] = 1;
                }
                else if(park[i].charAt(j) == 'O') {
                    map[i][j] = 0;
                }
                else if(park[i].charAt(j) == 'X'){
                    map[i][j] = -1;
                }
            }
        }
        
        int[] temp = move;
        
        // System.out.println(move[0] + " "+ move[1]);
        
        for(String st : routes) {
            String way = st.split(" ")[0];
            int len = Integer.parseInt(st.split(" ")[1]);
            
            int ny = move[0];
            int nx = move[1];
            
            // System.out.println("ny: " + ny);
            // System.out.println("nx: " + nx);            
            
            for(int i = 0; i < len; i++) {
                if(way.equals("N")) {
                    ny--;  
                } 
                else if(way.equals("S")) {
                    ny++;
                }
                else if(way.equals("W")) {
                    nx--;
                }
                else if(way.equals("E")){
                    nx++;
                }
                
                if(ny < 0 || ny >= height || nx < 0 || nx >= width) {
                    continue;
                }
                
                if(map[ny][nx] == -1) {
                    break;
                }
                
                if(i == len -1) {
                    move[0] = ny;
                    move[1] = nx;                    
                }
            }
        }
        
        answer = move;
        return answer;
    }
}
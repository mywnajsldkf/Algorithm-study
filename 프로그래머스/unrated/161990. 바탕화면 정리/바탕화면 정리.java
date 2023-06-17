import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int min_x = 51;
        int min_y = 51;
        int max_x = 0;
        int max_y = 0;
        
        for(int i = 0; i < wallpaper.length; i++) {     // y
            String line = wallpaper[i];
            
            for(int j = 0; j < line.length(); j++) {    // x
                if(line.charAt(j) == '#') {
                    // System.out.println(i + " " + j);
                    if(j < min_x) {
                        min_x = j;
                    }
                    if(i < min_y) {
                        min_y = i;
                    }
                    if(j >= max_x) {
                        max_x = j+1;
                    }
                    if(i >= min_y) {
                        max_y = i+1;
                    }
                }
            }
        }
        
        answer[0] = min_y;
        answer[1] = min_x;
        answer[2] = max_y;
        answer[3] = max_x;
        
        // System.out.println("max_x: " + (max_x) + " max_y: " + (max_y));
        
        return answer;
    }
}
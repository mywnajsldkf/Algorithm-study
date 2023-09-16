import java.util.*;

class Solution {
    public Integer[] solution(int brown, int yellow) {
        Integer[] answer = new Integer[2];
        answer[0] = 1;
        answer[1] = 2;
        
        int yy, yx, by, bx = 0;
        
        for(yy = 1; yy < yellow / 2; yy++) {
            if(yellow % yy == 0) {
                yx = yellow / yy;
                
                System.out.println("yy: " + yy + " / yx: " + yx);
            }
        }
        
        Arrays.sort(answer, Collections.reverseOrder());
        return answer;
    }
}
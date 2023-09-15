import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int pSize = p.length();
        int tSize = t.length();
        Long np = Long.parseLong(p);
        // System.out.println(np);
        int answer = 0;
        
        if(t.length() == 1) {
            if(Long.parseLong(t) <= np) {
                return 1;
            } else {
                return 0;
            }
        }
        
        for(int s = 0; s < tSize; s++) {
            if(s == tSize - pSize + 1) {
                break;
            }
            
            Long number = Long.parseLong(t.substring(s, s+pSize));
            // System.out.println(number);
            if(number <= np) {
                // System.o.println("t: " + number);

                answer++;
            }
        }
        
        return answer;
    }
}
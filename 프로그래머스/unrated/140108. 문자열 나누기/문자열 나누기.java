import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int same = 0; 
        int not_same = 0;
        
        char x = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            // 같으면 -> same에 더한다.
            if (x == s.charAt(i)) {
                same++;
            }
            // 다른게 나오면, not_same에 개수를 더한다.
            else if(x != s.charAt(i)) {
                not_same++;

                if(same == not_same && i < s.length()-1) {
                    answer++;
                    same = 0;
                    not_same = 0;
                    x = s.charAt(i+1);
                }
            }
        }
        return answer + 1;
    }
}
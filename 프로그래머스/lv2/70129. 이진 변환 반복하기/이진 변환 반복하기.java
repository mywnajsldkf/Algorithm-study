import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int count = 0;
        int zeros = 0;
        
        while(!s.equals("1")) {
            count += 1;
            String now = "";
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '1') {
                    now += '1';
                } else if (s.charAt(i) == '0') {
                    zeros += 1;
                }
            }
            
            int c = now.length();
            List<Integer> binary = new ArrayList<>();
            
            while(c != 0) {
                binary.add(c % 2);
                c /= 2;
            }
            
            s = "";
            
            for(int i = 0; i < binary.size(); i++) {
                s += binary.get(binary.size()-1-i);
            }
        }
        
        answer[0] = count;
        answer[1] = zeros;
        
        return answer;
    }
}
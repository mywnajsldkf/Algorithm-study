import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            // 중복된 키가 존재하지 않으면, 처음 값을 넣는 상황
            if(!map.containsKey(tmp)) {
                answer[i] = -1; 
            } else {
                int index = map.get(tmp);
                answer[i] = i-index;
            }
            map.put(tmp, i);
        }
        
        return answer;
    }
}
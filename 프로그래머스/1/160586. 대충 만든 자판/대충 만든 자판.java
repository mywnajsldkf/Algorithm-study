import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> map = new HashMap<>();
        for(String key : keymap) {
            for(int k = 0; k < key.length(); k++) {
                int idx = map.getOrDefault(key.charAt(k), k+1);
                map.put(key.charAt(k), Math.min(idx, k + 1));
            }
        }
        
        int i = 0;
        for(String target : targets) {
            int count = 0;
            for(int t = 0; t < target.length(); t++) {
                if(map.containsKey(target.charAt(t))) {
                    count += map.get(target.charAt(t));                    
                } else {
                    count = -1;
                    break;
                }
            }
            answer[i] = count;
            i++;
        }
        
        return answer;
    }
}
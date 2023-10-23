import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
       
        for(int i = 1; i <= 26; i++) {
            map.put(String.valueOf((char)(64+i)), i);
        }
        
        // System.out.println(map.size());
        
        int idx = 27;
        String word = "";
        for(int i = 0; i < msg.length(); i++) {
            word += String.valueOf(msg.charAt(i));
            
            // 만약 map에서 해당 낱말 포함하지 않으면 사전에 추가
            if(!map.containsKey(word)) {
                map.put(word, idx);
                idx++;
                System.out.println(word);
                // System.out.println(word.substring(0, word.length()-1));
                answer.add(map.get(word.substring(0, word.length()-1)));
                word = "";
                i--;
            }
        }
        answer.add(map.get(word));
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        
        // str1
        for(int i = 0; i < str1.length()-1; i++) {
            String element = "";
            if(str1.charAt(i) < 97 || str1.charAt(i) > 122) {
                continue;
            } 
            else if(str1.charAt(i+1) < 97 || str1.charAt(i+1) > 122) {
                continue;
            }
            element += str1.charAt(i);
            element += str1.charAt(i+1);
            map1.put(element, map1.getOrDefault(element, 0) + 1);
        }

        // str2
        for(int i = 0; i < str2.length()-1; i++) {
            String element = "";
            if(str2.charAt(i) < 97 || str2.charAt(i) > 122) {
                continue;
            } 
            else if(str2.charAt(i+1) < 97 || str2.charAt(i+1) > 122) {
                continue;
            }
            element += str2.charAt(i);
            element += str2.charAt(i+1);
            map2.put(element, map2.getOrDefault(element, 0) + 1);
        }

        if(map1.size() == 0 && map2.size() == 0) {
            answer = 65536;
            return answer;
        }
        
        // 교집합
        int intersaction = 0;
        for(String key : map1.keySet()) {
            if(map2.containsKey(key)) {
                intersaction += Math.min(map1.get(key), map2.get(key));
            }
        }
        
        // 합집합
        int union = 0;
        for(String key : map1.keySet()) {
            if(map2.containsKey(key)) {
                union += Math.max(map1.get(key), map2.get(key));
            } else {
                union += map1.get(key);
            } 
        }
        
        for(String key : map2.keySet()) {
            if(!map1.containsKey(key)) {
                union += map2.get(key);
            }
        }      
        
        answer = (int)Math.floor(((double) intersaction / (double) union)*65536);
        
        return answer;
    }
}
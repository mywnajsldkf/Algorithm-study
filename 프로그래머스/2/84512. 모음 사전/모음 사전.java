import java.util.*;

class Solution {
    static String[] alphabets = new String[]{"A", "E", "I", "O", "U"};
    static Map<String, Integer> map;
    static List<String> words;
    static String[] w;
    public int solution(String word) {
        int answer = 0;
        
        map = new HashMap<>();
        words = new ArrayList<>();
        
        for(int i = 1; i <= 5; i++) {   // length
            w = new String[i];
            dfs(i, 0);
        }
        
        Collections.sort(words);
        
        for(int i = 0; i < words.size(); i++) {
            map.put(words.get(i), i+1);
        }
        
        // System.out.println(words.size());
        
        answer = map.get(word);
        
        return answer;
    }
    
    static void dfs(int length, int depth) {
        if(length == depth) {
            String myWord = "";
            
            for(int i = 0; i < w.length; i++) {
                myWord += w[i];
            }
            
            words.add(myWord);
            
            return;
        }
        
        for(int i = 0; i < 5; i++) {
            w[depth] = alphabets[i];
            dfs(length, depth + 1);
        }
    }
}
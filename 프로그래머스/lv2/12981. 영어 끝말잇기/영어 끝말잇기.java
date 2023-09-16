import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> hashSet = new HashSet();
        
        int idx = 0;
        char tmp = ' ';
        for(String word : words) {
            int bSize = hashSet.size();
            hashSet.add(word);
            int aSize = hashSet.size();

            // 같은 순서로 말한 경우
            if(bSize == aSize) {    
                // System.out.println("같은 순서로 말한 경우");
                break;
            }
            
            if(idx != 0 && tmp != word.charAt(0)) {
                // System.out.println("단어가 이어지지 않는 경우");
                break;
            }
            
            tmp = word.charAt(word.length() - 1);
            idx++;
        }
        
        if(words.length != idx) {
            answer[0] = idx % n + 1;
            answer[1] = idx / n + 1;            
        }

        return answer;
    }
}
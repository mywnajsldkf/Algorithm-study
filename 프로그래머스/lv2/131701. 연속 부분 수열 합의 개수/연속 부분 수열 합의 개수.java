import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static int[] e;
    public int solution(int[] elements) {
        e = elements;
        
        // l: 길이
        for(int l = 1; l <= elements.length; l++) {
            // s: start 지점
            for(int s = 0; s < elements.length; s++) {
                dfs(s, l);
            }
        }
        int answer = set.size();
        return answer;
    }
    
    static void dfs(int start, int len) {
        int sum = 0;
        
        for(int s = start; s < start+len; s++) {
            sum += e[s % e.length];
        }
        set.add(sum);
        return;
    }
}
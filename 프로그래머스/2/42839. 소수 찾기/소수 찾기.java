import java.util.*;

class Solution {
    static Set<Integer> numSet;
    static boolean[] visited;
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        numSet = new HashSet<>();
        
        // 길이로 구한다.
        for(int l = 1; l <= numbers.length(); l++) {
            dfs(l, "", 0, numbers);
        }
        for(int n : numSet) {
            boolean isSosoo = true;
            if(n == 2) answer++;
            else if(n ==0 || n == 1) continue;
            else {
                for(int i = 2; i <= Math.sqrt(n); i++) {
                    if(n % i == 0) {
                        isSosoo = false;
                        break;
                    }
                }
                if(isSosoo) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    static void dfs(int length, String n, int depth, String numbers) {
        if(depth == length) {
            numSet.add(Integer.parseInt(n));
            return;
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(length, n + String.valueOf(numbers.charAt(i)), depth + 1, numbers);
                visited[i] = false;
            }
        }
    }
}
class Solution {
    static boolean[] visited;
    static int answer;
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        
        if(answer == Integer.MAX_VALUE) answer = 0;
        
        return answer;
    }
    
    void dfs(String now, String target, String[] words, int count) {
        if(now.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(visited[i]) continue;
            
            // 개수 비교
            int same_alpha = 0;
            
            for(int j = 0; j < words[i].length(); j++) {
                if(now.charAt(j) == words[i].charAt(j)) {
                    same_alpha++;
                }
            }
            
            if(same_alpha == now.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }
    }
}
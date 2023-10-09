class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(target, numbers, 0, 0);
        
        return answer;
    }
    
    static void dfs(int t, int[] n, int sum, int depth) {
        if(depth == n.length) {
            if(sum == t) {
                answer += 1;
            }
            return;
        }
        
        dfs(t, n, sum + n[depth], depth+1);
        dfs(t, n, sum - n[depth], depth+1);
    }
}
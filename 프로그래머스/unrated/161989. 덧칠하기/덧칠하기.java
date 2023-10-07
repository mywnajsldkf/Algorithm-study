class Solution {
    // n: 벽의 번호, m: 롤러의 길이, section: 다시 칠해야하는 곳
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] visited = new boolean[n+1];
        
        // for(int s : section) {
        //     wall[s] = true;
        // }
        
        int start = 0;
        
        for(int i = 0; i < section.length; i++) {
            int s = section[i];
            if(visited[s]) {
                continue;
            }
            answer++;
            for(int now = s; now < s+m; now++) {
                if(now > n) {
                    break;
                }
                visited[now] = true;
            }
        }
            
        return answer;
    }
}
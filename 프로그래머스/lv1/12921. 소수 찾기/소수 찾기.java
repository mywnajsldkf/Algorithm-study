class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] number = new boolean[n+1];
        
        for(int i = 2; i <= n/2; i++) {
            for(int now = i * 2; now <= n; now += i) {
                if(number[now]) {
                    continue;
                } else {
                    number[now] = true;
                }
            }
        }
        
        for(int i = 2; i <= n; i++) {
            if(!number[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}
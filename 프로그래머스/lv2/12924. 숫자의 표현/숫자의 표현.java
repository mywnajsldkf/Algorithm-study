class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int start = 1; start <= n; start++) {
            int temp = n;
            int tStart = start;
            while(temp > 0) {
                temp -= tStart;
                tStart += 1;
            }
            if(temp == 0) {
                answer += 1;
            }
        }
        return answer;
    }
}
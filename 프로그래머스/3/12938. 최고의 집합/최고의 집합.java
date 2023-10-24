class Solution {
    static int[] selected;
    static int target_n;
    static int target_s;
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if(n > s) {
            answer = new int[]{-1};
            return answer;
        }
        
        int init = s / n;   // 몫
        int mod = s % n;    // 나머지
        
        for(int i = 0; i < n; i++) {
            answer[i] = init;
        }
        
        int idx = n - 1;
        for(int m = 0; m < mod; m++) {
            answer[idx]++;
            idx--;
        }
    
        return answer;
    }
    
}

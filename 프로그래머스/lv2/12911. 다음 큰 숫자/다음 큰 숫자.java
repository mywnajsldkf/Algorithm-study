class Solution {
    public int solution(int n) {
        int answer = n;
        int originCnt = Integer.bitCount(n);
        
        while(true) {
            int oneCnt = Integer.bitCount(++answer);
            if(oneCnt == originCnt) {
                break;
            }
        }
        
        return answer;
    }
}
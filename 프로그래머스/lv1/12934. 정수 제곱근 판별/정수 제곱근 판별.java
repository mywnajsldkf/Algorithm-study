class Solution {
    public long solution(long n) {
        long answer = 0;
        
        long root = (long) Math.sqrt(n);
        
        if(root * root == n) {
            answer = (root + 1) * (root + 1);
        } else {
            answer = -1;
        }
        
        return answer;
    }
}
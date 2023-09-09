class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int result = 0;
        int temp = x;
        while(temp != 0) {
            result += temp % 10;
            temp /= 10;
        }
        
        if(x % result != 0) {
            answer = false;
        }
        
        return answer;
    }
}
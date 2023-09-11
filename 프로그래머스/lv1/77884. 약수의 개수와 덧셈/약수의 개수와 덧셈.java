class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++) {
            int count = yaksoo(i);
            if(yaksoo(i) % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        
        return answer;
    }
    
    static int yaksoo(int number) {
        int count = 0;
        int root = (int) Math.sqrt(number);

        for(int i = 1; i <= root; i++) {
            if(number % i == 0) {
                if(i == Math.sqrt(number)) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        
        return count;
    }
}